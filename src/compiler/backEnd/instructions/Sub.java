package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Sub extends Instruction {

  public Sub(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }
  
  public Sub(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  public Sub(Operand destination, Operand source) {
    super(destination, source);
  }
  
  @Override
  public String toString() {
    String str = "SUB" + getCond() + getDestination() + 
        ", " + getPrimarySource();
    if (getSecondarySource() != null) {
      str += ", " + getSecondarySource();
    }
    return str;
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
