package compiler.instructions;

import compiler.operands.Operand;

public class Mov extends Instruction {
  
  public Mov(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }
  
  public Mov(Operand destination, Operand source) {
    super(destination, source);
  }
  
}
