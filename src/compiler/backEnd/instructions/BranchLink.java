package compiler.backEnd.instructions;

public class BranchLink implements Token {
  
  private final Cond cond;
  private final Label label;
  
  public BranchLink(Cond cond, Label label) {
    this.cond = cond;
    this.label = label;
  }
  
  public BranchLink(Label label) {
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
    return "BL" + getCond() + " " + getLabel();
  }
  
}
