package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Ldr extends Instruction {
  
  public Ldr(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }

  public Ldr(Operand destination, Operand source) {
    super(destination, source);
  }
  
  @Override
  public String toString() {
    return "LDR" + getCond() + getDestination() + 
        ", " + getPrimarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
