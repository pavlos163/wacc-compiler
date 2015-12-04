package compiler.instructions;

import compiler.operands.Operand;

public class Pop extends Instruction {

  public Pop(Operand destination) {
    super(destination);
  }

  @Override
  public String toString() {
    return "POP " + destination;
  }

}
