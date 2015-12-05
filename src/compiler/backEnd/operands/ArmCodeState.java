package compiler.backEnd.operands;

import java.util.Deque;
import java.util.LinkedList;

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
  
  private boolean pString, pBool, pInt, pRef, printLn, 
      printChar, readInt, readChar; 
  
  public static Deque<Token> preDefinedFunctions = 
      new LinkedList<Token>();
  
  
  private static Deque<Token> startFunction(String funcName) {
    return null;
  }
  
  private static Deque<Token> endFunction() {
    return null;
  }
  
  public static Deque<Token> usePrintString() {
    // We need to put something to the Data Section.
    startFunction(PRINT_STRING);
    return null;
  }
  
}
