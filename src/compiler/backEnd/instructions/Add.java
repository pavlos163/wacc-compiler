package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Add extends Instruction {
  
  public Add(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }

  public Add(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  @Override
  public String toString() {
    return "ADD" + getCond() + " " + getDestination() + ", " + 
        getPrimarySource() + ", " + getSecondarySource();
  }
  
}
