package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;
import compiler.backEnd.operands.Register;

public class Add extends Instruction {
 
  public Add(boolean s, Operand destination, Operand primarySource,
      Operand secondarySource) {
    super(s, destination, primarySource, secondarySource);
  }
  
  public Add(Operand destination, Operand primarySource) {
    super(destination, primarySource);
  }
  
  public Add(Cond cond, Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(cond, destination, primarySource, secondarySource);
  }

  public Add(Operand destination, Operand primarySource, 
      Operand secondarySource) {
    super(destination, primarySource, secondarySource);
  }
  
  public Add(Register destination, Register primarySource, 
      Register secondarySource, int offset) {
    super(destination, primarySource, secondarySource, offset);
  }

  @Override
  public String toString() {
    String str = "ADD" + (s?"S":"") + getCond() + getDestination() + ", " + 
        getPrimarySource() + ", " + getSecondarySource();
    if (offset != 0) {
      str += ", LSL #" + offset;
    }
    return str;
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
