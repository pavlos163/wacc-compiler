package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Str extends Instruction {
  
  boolean isByte = false;
  
  public Str(Cond cond, Operand destination, Operand source, boolean isByte) {
    super(cond, destination, source);
    this.isByte = isByte;
  }
  
  public Str(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }
  
  public Str(Operand destination, Operand source) {
    super(destination, source);
  }
  
  public Str(Operand destination, Operand source, boolean isByte) {
    super(destination, source);
    this.isByte = isByte;
  }
  
  @Override
  public String toString() {
    String s = "";
    if (isByte) {
      s += "STRB";
    }
    else {
      s += "STR";
    }
    return s + getCond() + getDestination()
        + ", " + getPrimarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
