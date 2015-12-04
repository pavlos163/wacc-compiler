package compiler.frontEnd.literals;

import compiler.CodePosition;
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

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
