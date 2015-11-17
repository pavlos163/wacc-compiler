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
  public boolean equals(Object obj) {
    if (! (obj instanceof ArrType)) {
      return false;
    }
    if (type == null) {
      return true;
    }
    ArrType arrType = (ArrType) obj;
    if (arrType.getType() == null || type.equals(arrType.type))
      return true;
    return false;
  }
  
  @Override
  public String toString() {
    if (type.equals(BaseType.typeChar)) {
      return "STRING";
    }
    else return type.toString() + "[]";
  }

}
