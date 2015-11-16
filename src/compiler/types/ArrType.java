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
    if (obj == null) {
      return true;
    }
    if (obj instanceof ArrType) {
      ArrType arrType = (ArrType) obj;
      if (arrType.getType() == null) { // We assign an array to another array.
        return true;
      }
      return type == null || type.equals(arrType.getType());
    } else if (obj instanceof PairType) {
      PairType pairType = (PairType) obj;
      return pairType == null || type.equals(pairType);
    } else {
      BaseType baseType = (BaseType) obj;
      return type.equals(baseType);
    }
  }
  
  @Override
  public String toString() {
    if (type.equals(BaseType.typeChar)) {
      return "STRING";
    }
    else return type.toString() + "[]";
  }

}
