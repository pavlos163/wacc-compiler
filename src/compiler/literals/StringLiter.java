package compiler.literals;

import compiler.CodePosition;
import compiler.types.ArrType;
import compiler.types.BaseType;
import compiler.types.Type;

public class StringLiter implements Liter {
  
  private final String value;
  private final CodePosition codePos;
  
  public StringLiter(String value, CodePosition codePos) {
    this.value = value.substring(1, value.length() - 1);
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    return new ArrType(BaseType.typeChar);
  }

  @Override
  public String getString() {
    return value;
  }

}
