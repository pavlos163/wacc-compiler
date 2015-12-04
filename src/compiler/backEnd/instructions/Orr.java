package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Orr extends Instruction {

  public Orr(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }
  
  public Orr(Operand destination, Operand primarySource,
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  @Override
  public String toString() {
    return "ORR" + getCond() + " " + getDestination() + ", " + 
        getPrimarySource() + ", " + getSecondarySource();
  }
  
}
