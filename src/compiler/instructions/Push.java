package compiler.instructions;

import compiler.operands.Operand;

public class Push extends Instruction {

  public Push(Operand destination) {
    super(destination);
  }
  
  @Override
  public String toString() {
    return "PUSH " + destination;
  }
  
}
