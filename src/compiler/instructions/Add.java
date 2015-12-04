package compiler.instructions;

import compiler.operands.Operand;

public class Add extends Instruction {
  
  public Add(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }

  public Add(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
}
