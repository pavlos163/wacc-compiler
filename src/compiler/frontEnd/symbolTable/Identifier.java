package compiler.frontEnd.symbolTable;

import compiler.CodePosition;
import compiler.frontEnd.types.Type;

public class Identifier {
  
  private final Type identType;
  private CodePosition codePos;
  private int stackPosition = -1;
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
  
  public void setStackPosition(int newPosition) {
    stackPosition = newPosition;
  }
  
  public boolean isDeclaration() {
    return isDeclaration;
  }
  
  public void setDeclaration(boolean value) {
    isDeclaration = value;
  }
  
}
