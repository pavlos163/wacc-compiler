package compiler.backEnd.operands;

public class Address implements Operand {
  
  private final Register reg;
  private int offset;
  
  public Address(Register reg) {
    this.reg = reg;
    this.offset = 0;
  }
    
  public Address(Register reg, int offset) {
    this.reg = reg;
    this.offset = offset;
  }
  
  public Register getRegister() {
    return reg;
  }
    
  public int getOffset() {
    return offset;
  }
  
  @Override
  public String toString() {
    String str = "[" + reg;
    if (offset != 0) {
      str += ", " + offset;
    }
    str += "]";
    return str;
  }
  
}
