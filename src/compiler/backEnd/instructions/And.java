package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class And extends Instruction {

  public And(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }
  
  public And(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  @Override
  public String toString() {
    return "AND" + getCond() + getDestination() + ", " + 
        getPrimarySource() + ", " + getSecondarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
