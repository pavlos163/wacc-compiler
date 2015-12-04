package compiler.backEnd.instructions;

import compiler.backEnd.operands.Label;

public class Branch {
  
  private final Cond cond;
  private final Label label;
  
  public Branch(Cond cond, Label label) {
    this.cond = cond;
    this.label = label;
  }
  
  public Branch(Label label) {
    this.cond = Cond.AL;
    this.label = label;
  }
  
  public Cond getCond() {
    return cond;
  }
  
  public Label getLabel() {
    return label;
  }
  
  @Override
  public String toString() {
    return "B" + getCond() + " " + getLabel();
  }
  
}
