package compiler.backEnd.instructions;

public class AssemblerDirective implements Token {
  
  private final String value;
  
  public AssemblerDirective(String value) {
    this.value = value;
  }
  
  public String getValue() {
    return value;
  }
  
  @Override
  public String toString() {
    return getValue();
  }
  
}
