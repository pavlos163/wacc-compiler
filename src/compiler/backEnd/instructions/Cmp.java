package compiler.backEnd.instructions;

import compiler.backEnd.operands.ImmediateValue;
import compiler.backEnd.operands.Operand;

public class Cmp extends Instruction {

  public Cmp(Cond cond, Operand destination, Operand source) {
    super(cond, destination, source);
  }
  
  public Cmp(Operand destination, Operand source) {
    super(destination, source);
  }
  
  public Cmp(Operand destination, Operand source, ImmediateValue asrFlag) {
    super(destination, source, asrFlag);
  }
  
  @Override
  public String toString() {
    Operand asrFlags = getSecondarySource();
    String secondary = "";
    if (asrFlags != null) {
      secondary = ", " + asrFlags.toString();
    }
    return "CMP" + getCond() + getDestination() + ", " +
        getPrimarySource() + secondary;
  }

  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
