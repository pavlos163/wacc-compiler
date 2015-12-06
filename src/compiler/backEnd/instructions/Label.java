package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;

public class Label implements Operand, Token {
  
  private final String label;
  
  public Label(String label) {
    this.label = label;
  }
  
  public String getLabel() {
    return label + ":";
  }
  
  @Override
  public String toString() {
    return label;
  }
  
  @Override
  public <T> T accept(InstructionVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
