package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.AssemblerDirective;
import compiler.backEnd.instructions.Branch;
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
  public void freePair(int msgNum){
  	code.add(new Push(Register.lr));
  	code.add(new Cmp(Register.r0, new ImmediateValue("0")));
  	code.add(new Ldr(Cond.EQ, Register.r0, new ImmediateValue("=msg_" + (msgNum))));
  	code.add(new Branch(Cond.EQ, new Label("p_throw_runtime_error")));
  	code.add(new Push(new ImmediateValue("{r0}")));//not sure if I should use adress
  	code.add(new Ldr(Register.r0,new Address(Register.r0)));
  	code.add(new BranchLink(new Label("free")));
  	code.add(new Ldr(Register.r0,new Address(Register.sp)));
  	code.add(new Ldr(Register.r0,new Address(Register.r0)));
  	code.add(new BranchLink(new Label("free")));
  	code.add(new Pop(new Address(Register.r0)));
  	code.add(new BranchLink(new Label("free")));
  	code.add(new Pop(Register.pc));
  	
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

