package compiler.operands;

public class Label implements Operand {
  
  private final String label;
  
  public Label(String label) {
    this.label = label;
  }
  
  public String getLabel() {
    return label;
  }
  
}
