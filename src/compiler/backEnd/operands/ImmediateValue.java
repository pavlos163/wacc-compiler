package compiler.backEnd.operands;

public class ImmediateValue implements Operand {
  
  private final String value;
  
  public ImmediateValue(String value) {
    this.value = value;
  }
  
  public ImmediateValue(int value) {
    this.value = Integer.toString(value);
  }
  
  public String getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return "=" + value;
  }
  
}
