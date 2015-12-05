package compiler.backEnd.operands;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.BranchLink;
import compiler.backEnd.instructions.Label;
import compiler.backEnd.instructions.Ldr;
import compiler.backEnd.instructions.Mov;
import compiler.backEnd.instructions.Pop;
import compiler.backEnd.instructions.Push;
import compiler.backEnd.instructions.Token;

public class ArmCodeState {
  
  public static final String PRINT_STRING = "p_print_string";
  public static final String PRINT_BOOL = "p_print_bool";
  public static final String PRINT_INT = "p_print_int";
  public static final String PRINT_REF = "p_print_reference";
  public static final String PRINTLN = "p_print_ln";
  public static final String PRINT_CHAR = "putchar";
  public static final String READ_INT = "p_read_int";
  public static final String READ_CHAR = "p_read_char";
  
  private Set<String> usedFunctions;
  
  public ArmCodeState() {
  }
  
  private Deque<Token> initializeCode() {
    Deque<Token> code = new LinkedList<Token>();
    return code;
  }
  
  public Deque<Token> afterMainInstructions = 
      new LinkedList<Token>();
  
  
  private Deque<Token> startFunction(String funcName) {
    Deque<Token> code = initializeCode();
    code.add(new Label(funcName));
    code.add(new Push(Register.lr));
    return code;
  }
  
  private Deque<Token> endFunction() {
    Deque<Token> code = initializeCode();
    code.add(new Pop(Register.pc));
    // Something to be done about scopes here.
    // When we exit a function we go to parent scope.
    // We have to figure how are we going to deal with that.
    return code;
  }
  
  private Deque<Token> endPrintFunction(String branchVal) {
    Deque<Token> code = initializeCode();
    code.add(new Add(Register.r0, Register.r0, new ImmediateValue(4)));
    code.add(new BranchLink(new Label(branchVal)));
    code.add(new Mov(Register.r0, new ImmediateValue(0)));
    code.add(new BranchLink(new Label("fflush")));
    code.addAll(endFunction());
    return code;
  }
  
  public void usePrintString() {
    // We need to put something to the Data Section.
    String message = null;
    if (usedFunctions.contains(PRINT_STRING)) {
      return;
    }
    Deque<Token> code = startFunction(PRINT_STRING);
    code.add(new Ldr(Register.r1, Register.r0));
    code.add(new Add(Register.r2, Register.r0, new ImmediateValue(4)));
    ImmediateValue messageVal = new ImmediateValue(message);
    messageVal.setPrefix("=");
    code.add(new Ldr(Register.r0, messageVal));
    code.addAll(endPrintFunction("printf"));
    usedFunctions.add(PRINT_STRING);
  }
  
}
