package compiler.frontEnd.types;

import compiler.CodePosition;

public enum BaseType implements Type {
  
  typeInt,
  typeChar,
  typeBool;

  @Override
  public CodePosition getPosition() {
    return null;
  }
  
  @Override
  public String toString() {
    if (this.equals(null)) {
      return "null";
    }
    return super.toString().substring(4);
  }
  
  public int getSize() {
    if (this.equals(typeInt)) {
      return 4;
    }
    return 1;
  }
  
}
