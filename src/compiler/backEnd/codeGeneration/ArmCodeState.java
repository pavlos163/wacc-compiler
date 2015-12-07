package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.AssemblerDirective;
import compiler.backEnd.instructions.BranchLink;
import compiler.backEnd.instructions.Cmp;
import compiler.backEnd.instructions.Cond;
import compiler.backEnd.instructions.Label;
import compiler.backEnd.instructions.Ldr;
import compiler.backEnd.instructions.Mov;
import compiler.backEnd.instructions.Pop;
import compiler.backEnd.instructions.Push;
import compiler.backEnd.instructions.Token;
import compiler.backEnd.operands.Address;
import compiler.backEnd.operands.ImmediateValue;
import compiler.backEnd.operands.Register;

public class ArmCodeState {
  
  public static final String PRINT_STRING = "p_print_string";
  public static final String PRINT_BOOL = "p_print_bool";
  public static final String PRINT_INT = "p_print_int";
  public static final String PRINT_REF = "p_print_reference";
  public static final String PRINT_LN = "p_print_ln";
  public static final String PRINT_CHAR = "putchar";
  public static final String READ_INT = "p_read_int";
  public static final String READ_CHAR = "p_read_char";
  public static final String INTEGER_OVERFLOW = "p_throw_overflow_error";
  public static final String RUNTIME_ERROR = "p_throw_runtime_error";
  public static final String DIVIDE_BY_ZERO = "p_check_divide_by_zero";
  
  private Set<String> usedFunctions = new HashSet<String>();
  private Deque<Token> code = new LinkedList<Token>();
  private Deque<Token> data = new LinkedList<Token>();
  private Map<String, String> msgData = new HashMap<String, String>();
  private MsgGenerator msgGenerator = new MsgGenerator();
  
  public ArmCodeState() {
    data.add(new AssemblerDirective(".data"));
  }
  
  private void addToDataSection(String message, Label generatedMsg) {
    data.add(generatedMsg);
    // TODO: Fix problem special characters make.
    data.add(new AssemblerDirective(".word " + 
        (message.length() - countSlash(message))));
    data.add(new AssemblerDirective(".ascii " + "\"" + message
        + "\""));
  }
  
  private void startFunction(String funcName) {
    code.add(new Label(funcName));
    code.add(new Push(Register.lr));
  }
  
  private void endFunction() {
    code.add(new Pop(Register.pc));
    // Something to be done about scopes here.
    // When we exit a function we go to parent scope.
    // We have to figure how are we going to deal with that.
  }
  
  private void endPrintFunction(String branchVal) {
    code.add(new Add(Register.r0, Register.r0, new ImmediateValue(4)));
    code.add(new BranchLink(new Label(branchVal)));
    code.add(new Mov(Register.r0, new ImmediateValue(0)));
    code.add(new BranchLink(new Label("fflush")));
    endFunction();
  }
 
  private void endReadFunction() {
    code.add(new Add(Register.r0, Register.r0, new ImmediateValue(4)));
    code.add(new BranchLink(new Label("scanf")));
    endFunction();
  }
  // Functions to handle print.
  public void usePrintString() {
    String message = "%.*s\\0";
    updateData(message);
    if (usedFunctions.contains(PRINT_STRING)) {
      return;
    }
    startFunction(PRINT_STRING);
    code.add(new Ldr(Register.r1, new Address(Register.r0)));
    code.add(new Add(Register.r2, Register.r0, new ImmediateValue(4)));
    ImmediateValue messageVal = new ImmediateValue(msgData.get(message));
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    endPrintFunction("printf");
    usedFunctions.add(PRINT_STRING);
  }
  
  public void usePrintBool() {
    String trueValue = "true\\0";
    String falseValue = "false\\0";
    updateData(trueValue);
    updateData(falseValue);
    if (usedFunctions.contains(PRINT_BOOL)) {
      return;
    }
    startFunction(PRINT_BOOL);
    code.add(new Cmp(Register.r0, new ImmediateValue(0)));
    ImmediateValue trueImm =  new ImmediateValue(msgData.get(trueValue));
    trueImm.setPrefix("=");
    code.add(new Ldr(Cond.NE ,Register.r0, trueImm));
    ImmediateValue falseImm = new ImmediateValue(msgData.get(falseValue));
    falseImm.setPrefix("=");
    code.add(new Ldr(Cond.EQ, Register.r0, falseImm));
    endPrintFunction("printf");
    usedFunctions.add(PRINT_BOOL);
  }
  
  public void usePrintln() {
    String message = "\\0";
    updateData(message);
    if (usedFunctions.contains(PRINT_LN)) {
      return;
    }
    startFunction(PRINT_LN);
    ImmediateValue messageVal = new ImmediateValue(msgData.get(message));
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    endPrintFunction("puts"); // since \n is considered a single character.
    usedFunctions.add(PRINT_LN);
  }

  public void usePrintInt() {
    String identifier = "%d\\0";
    updateData(identifier);
    if (usedFunctions.contains(PRINT_INT)) {
      return;
    }
    startFunction(PRINT_INT);
    code.add(new Mov(Register.r1, Register.r0));
    ImmediateValue messageVal = new ImmediateValue(msgData.get(identifier));
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    endPrintFunction("printf");
    usedFunctions.add(PRINT_INT);
  }
  
  public void useReadInt() {
    String identifier = "%d\\0";
    updateData(identifier);
    if (usedFunctions.contains(READ_INT)) {
      return;
    }
    startFunction(READ_INT);
    code.add(new Mov(Register.r1, Register.r0));
    ImmediateValue messageVal = new ImmediateValue(msgData.get(identifier));
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    endReadFunction();
    usedFunctions.add(READ_INT);
  }
  
  public void useReadChar() {
    String identifier = " %c\\0";
    updateData(identifier);
    if (usedFunctions.contains(READ_CHAR)) {
      return;
    }
    startFunction(READ_CHAR);
    code.add(new Mov(Register.r1, Register.r0));
    ImmediateValue messageVal = new ImmediateValue(msgData.get(identifier));
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    endReadFunction();
    usedFunctions.add(READ_CHAR);
  }
  // Functions that handle data.
  public void throwOverflow() {
    String errorMessage = "OverflowError: the result is too small/large" +
    		" to store in a 4-byte signed-integer.\\n";
    updateData(errorMessage);
    if (usedFunctions.contains(INTEGER_OVERFLOW)) {
      return;
    }
    code.add(new Label(INTEGER_OVERFLOW));
    ImmediateValue messageVal = new ImmediateValue(msgData.get(errorMessage));
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    code.add(new BranchLink(new Label(RUNTIME_ERROR)));
    throwRuntimeError();
    usedFunctions.add(INTEGER_OVERFLOW);
  }
  
  public void checkDivisionByZero() {
    String errorMessage = "DivideByZeroError: divide or modulo by zero\\n\\0";
    updateData(errorMessage);
    if (usedFunctions.contains(DIVIDE_BY_ZERO)) {
      return;
    }
    startFunction(DIVIDE_BY_ZERO);
    code.add(new Cmp(Register.r1, new ImmediateValue(0)));
    ImmediateValue messageVal = new ImmediateValue(msgData.get(errorMessage));
    messageVal.setPrefix("=");
    code.add(new Ldr(Cond.EQ, Register.r0, messageVal));
    code.add(new BranchLink(Cond.EQ, new Label(RUNTIME_ERROR)));
    endFunction();
    throwRuntimeError();
    usedFunctions.add(DIVIDE_BY_ZERO);
  }
  
  public void throwRuntimeError() {
    if (usedFunctions.contains(RUNTIME_ERROR)) {
      return;
    }
    code.add(new Label(RUNTIME_ERROR));
    code.add(new BranchLink(new Label(PRINT_STRING)));
    code.add(new Mov(Register.r0, new ImmediateValue(-1)));
    code.add(new BranchLink(new Label("exit")));
    usePrintString();
    usedFunctions.add(RUNTIME_ERROR);
  }
 
  public Deque<Token> getData() {
    return data;
  }
  
  public String updateData(String message) {
    if (!msgData.containsKey(message)) {
      Label generatedMsg = msgGenerator.generateMsg();
      msgData.put(message, generatedMsg.toString());
      addToDataSection(message, generatedMsg);
      return generatedMsg.toString();
    }
    return msgData.get(message);
  }
 
  public int getSize() {
    return code.size();
  }
  
  public Deque<Token> getAfterMainLabelCode() {
    return this.code;
  }
  
  private int countSlash(String msg) {
    int cnt = 0;
    for (int i = 0; i < msg.length(); ++i) {
      if (msg.charAt(i) == '\\') {
        cnt++;
      }
    }
    return cnt;
  }

}

