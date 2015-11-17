package compiler.literals;

import compiler.CodePosition;
import compiler.errorHandling.SyntaxException;
import compiler.types.BaseType;
import compiler.types.Type;

public class IntLiter implements Liter {
  
  private final int value;
  private final CodePosition codePos; 
  
  public IntLiter(long value, CodePosition codePos) {
    this.value = (int) value;
    this.codePos = codePos;
    if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
      throw new SyntaxException("At: " + codePos + " integer "
          + "overflow: " + value);
    }
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    return BaseType.typeInt;
  }

  @Override
  public String getString() {
    return "" + value;
  }
  
  public int getValue() {
    return value;
  }
  
}
