package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Str extends Instruction {

  public Str(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }
  
  public Str(Operand destination, Operand source) {
    super(destination, source);
  }
  
  @Override
  public String toString() {
    return "STR" + getCond() + " " + getDestination()
        + ", " + getPrimarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
