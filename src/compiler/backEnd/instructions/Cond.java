package compiler.backEnd.instructions;

public enum Cond {
  
  EQ,
  NE,
  GT,
  GE,
  LT,
  LE,
  AL,
  CS,
  VS;
  
  @Override
  public String toString() {
    if (this.equals(Cond.AL)) {
      return "";
    }
    return name() + " ";
  }
  
}
