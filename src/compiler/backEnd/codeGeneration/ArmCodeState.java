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
        message.length()));
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
    code.add(new Ldr(Cond.NE ,Register.r0, 
        new ImmediateValue(msgData.get(trueValue))));
    code.add(new Ldr(Cond.EQ, Register.r0, 
        new ImmediateValue(msgData.get(falseValue))));
    endPrintFunction("printf");
    usedFunctions.add(PRINT_BOOL);
  }
  
  public void usePrintln() {
    String message = "Hey ln";
    if (usedFunctions.contains(PRINT_LN)) {
      return;
    }
    startFunction(PRINT_LN);
    code.add(new Ldr(Register.r0, new ImmediateValue(message)));
    endPrintFunction("puts"); // since \n is considered a single character.
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
  
  public int getSize() {
    return code.size();
  }
  
  public Deque<Token> getAfterMainLabelCode() {
    return this.code;
  }
  
}