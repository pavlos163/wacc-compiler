package compiler.frontEnd.symbolTable;

import compiler.CodePosition;
import compiler.frontEnd.types.Type;

public class Identifier {
  
  private final Type identType;
  private CodePosition codePos;
  private int stackPosition = -1;
  private int stackSize;
  private boolean isDeclaration = true;
  
  public Identifier(Type type, CodePosition codePos) {
     this.identType = type;
     this.codePos = codePos;
  }
  
  public Type getType() {
    return identType;
  }
  
  public CodePosition getPosition() {
    return codePos;
  }
  
  public int getStackPosition() {
    return stackPosition;
  }
  
  public int getStackSize() {
    return stackSize;
  }
  
  public void setStackPosition(int newPosition, int stackSize) {
    stackPosition = newPosition;
    this.stackSize = stackSize;
  }
  
  public boolean isDeclaration() {
    return isDeclaration;
  }
  
  public void setDeclaration(boolean value) {
    isDeclaration = value;
  }
  
}
