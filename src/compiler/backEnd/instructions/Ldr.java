package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Ldr extends Instruction {
  
  private boolean signedByte = false;
  
  public Ldr(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }

  public Ldr(Operand destination, Operand source) {
    super(destination, source);
  }
  
  public Ldr(Operand destination, Operand source, boolean signedByte) {
    super(destination, source);
    this.signedByte = signedByte;
  }

  @Override
  public String toString() {
    String str = "LDR";
    if (signedByte) {
      str += "SB";
    }
    return str + getCond() + getDestination() + 
        ", " + getPrimarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
