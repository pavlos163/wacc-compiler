package compiler.types;

import compiler.CodePosition;

public class ArrType implements Type {
  
  private final Type type;
  
  public ArrType(Type type) {
    this.type = type;
  }

  @Override
  public CodePosition getPosition() {
    return null;
  }
  
  public Type getType() {
    return type;
  }
  
  @Override
  public String toString() {
    if (type.equals(BaseType.typeChar)) {
      return "STRING";
    }
    else return type.toString() + "[]";
  }

}
