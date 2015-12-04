package compiler.instructions;

import compiler.operands.Operand;

public class Eor extends Instruction {
  
  public Eor(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }

  public Eor(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
}
