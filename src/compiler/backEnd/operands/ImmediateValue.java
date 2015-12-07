package compiler.backEnd.operands;

public class ImmediateValue implements Operand {
  
  private final String value;
  private String prefix;
  
  public ImmediateValue(String value) {
    this.value = value;
    this.prefix = "#";
  }
  
  public ImmediateValue(int value) {
    this.value = Integer.toString(value);
    this.prefix = "#";
  }
  
  public String getValue() {
    if (prefix.equals("=") || prefix.equals("#") || prefix.equals("")) {
      return prefix + value;
    }
    return null;
  }
  
  public void setPrefix(String newPrefix) {
    prefix = newPrefix;
  }
  
  @Override
  public String toString() {
    return getValue();
  }
  
}
