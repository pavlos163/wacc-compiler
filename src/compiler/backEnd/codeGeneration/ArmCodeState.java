package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.BranchLink;
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
  // Not sure about it.
  private Map<Integer, String> msgData;
  
  public ArmCodeState() {
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
  
  public void usePrintString() {
    // We need to put something to the Data Section.
    String message = "Hey";
    if (usedFunctions.contains(PRINT_STRING)) {
      return;
    }
    startFunction(PRINT_STRING);
    code.add(new Ldr(Register.r1, new Address(Register.r0)));
    code.add(new Add(Register.r2, Register.r0, new ImmediateValue(4)));
    ImmediateValue messageVal = new ImmediateValue(message);
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    endPrintFunction("printf");
    usedFunctions.add(PRINT_STRING);
  }
  
  public void usePrintln() {
    String message = "Hey ln";
    if (usedFunctions.contains(PRINT_LN)) {
      return;
    }
    startFunction(PRINT_LN);
    code.add(new Ldr(Register.r0, new ImmediateValue(message)));
    endPrintFunction("puts"); // since \n is considered a single characher.
  }
  
  public Deque<Token> getData() {
    return data;
  }
  
  public void updateData(Label msg) {
    return;
  }
  
  public int getSize() {
    return code.size();
  }
  
  public Deque<Token> getAfterMainLabelCode() {
    return this.code;
  }
  
}
