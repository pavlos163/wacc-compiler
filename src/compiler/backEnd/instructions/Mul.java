package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Mul extends Instruction {

  public Mul(boolean s, Operand destination, Operand overflowReg, 
      Operand primarySource, Operand secondarySource) {
    super(s, destination, overflowReg, primarySource, secondarySource);
  }
  
  public Mul(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }
  
  public Mul(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  @Override
  public String toString() {
    return "MUL" + (s?"S":"") +  getCond() + getDestination() + ", " + 
        (s?getOverflowReg():"") + ", " + getPrimarySource() + ", " + getSecondarySource();
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
