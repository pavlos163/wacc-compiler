package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Eor extends Instruction {
  
  public Eor(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }

  public Eor(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  @Override
  public String toString() {
    return "EOR" + getCond() + " " + getDestination() + ", " + 
        getPrimarySource() + ", " + getSecondarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
