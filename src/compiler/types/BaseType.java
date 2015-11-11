package compiler.types;

import compiler.CodePosition;

public enum BaseType implements Type {
  
  typeInt,
  typeChar,
  typeBool;

  @Override
  public CodePosition getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

}
