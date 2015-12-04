package compiler.instructions;

import compiler.operands.Operand;

public class Cmp extends Instruction {

  public Cmp(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }
  
  public Cmp(Operand destination, Operand source) {
    super(destination, source);
  }
  
}
