package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Mul extends Instruction {

  public Mul(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }
  
  public Mul(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  @Override
  public String toString() {
    return "MUL" + getCond() + getDestination() + ", " + 
        getPrimarySource() + ", " + getSecondarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
