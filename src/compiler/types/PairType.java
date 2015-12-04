package compiler.types;

import compiler.CodePosition;

public class PairType implements Type {
  
  private Type fst;
  private Type snd;
  
  public PairType(Type fst, Type snd) {
    if (fst instanceof PairType) {
      this.fst = new PairType();
    }
    this.fst = fst;
    if (snd instanceof PairType) {
      this.snd = new PairType();
    }
    this.snd = snd;
  }
  
  public PairType() {
    this.fst = null;
    this.snd = null;
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
    String first,second;
    
    if (fst == null) {
      first = "unknown";
    } else first = fst.toString();
    
    if (snd == null) {
      second = "unknown";
    } else {
      second = snd.toString();
    }
        
    return "(" + first + ", " + second + ")";
  }
  
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof PairType)) {
      return false;
    }
    PairType rhs = (PairType) obj;
    return typeCheck(fst, rhs.fst) && typeCheck(snd, rhs.snd);
  }
  
  private boolean typeCheck(Type lhs, Type rhs) {
    if (rhs == null || lhs == null) {
      return true; // When we have a pair the type is null.
    }
    else {
      return lhs.equals(rhs);
    }
  }
  
  @Override 
  public int hashCode() {
    return 0;
  }
  
}
