package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Ldr extends Instruction {
  
  private boolean isByte;
  
  public Ldr(Cond cond, Operand destination, Operand source, boolean isByte) {
    super(cond, destination, source);
    this.isByte = isByte;
  }
  
  public Ldr(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }

  public Ldr(Operand destination, Operand source, boolean isByte) {
    super(destination, source);
    this.isByte = isByte;
  }
  
  public Ldr(Operand destination, Operand source) {
    super(destination, source);
  }
  
  @Override
  public String toString() {
    String s = "";
    if (isByte) {
      s += "LDRB";
    }
    else {
      s += "LDR";
    }
    return s + getCond() + " " + getDestination()
        + ", " + getPrimarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
