package compiler.operands;

public class ImmediateValue implements Operand {
  
  private final String value;
  
  public ImmediateValue(String value) {
    this.value = value;
  }
  
  public String getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return "=" + value;
  }
  
}
