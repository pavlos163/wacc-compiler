package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Push extends Instruction {

  public Push(Operand destination) {
    super(destination);
  }
  
  @Override
  public String toString() {
    return "PUSH " + "{" + getDestination() + "}";
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
