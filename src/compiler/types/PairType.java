package compiler.types;

import compiler.CodePosition;

public class PairType implements Type {
  
  private final Type fst;
  private final Type snd;
  
  public PairType(Type fst, Type snd) {
    this.fst = fst;
    this.snd = snd;
  }

  @Override
  public CodePosition getPosition() {
    return null;
  }
  
  public Type getFst() {
    return fst;
  }
  
  public Type getSnd() {
    return snd;
  }
  
  @Override
  public String toString() {
    String first = fst.toString();
    String second = snd.toString();
        
    return "(" + first + ", " + second + ")";
  }
  
}
