package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Mov extends Instruction {
  
  public Mov(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }
  
  public Mov(Operand destination, Operand source) {
    super(destination, source);
  }
  
  @Override
  public String toString() {
    return "MOV" + getCond() + getDestination() + ", " + 
        getPrimarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
