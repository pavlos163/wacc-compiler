package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Pop extends Instruction {

  public Pop(Operand destination) {
    super(destination);
  }

  @Override
  public String toString() {
    return "POP " + "{" + getDestination() + "}";
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
