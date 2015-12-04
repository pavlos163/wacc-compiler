package compiler.frontEnd.literals;

import compiler.CodePosition;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

public class BoolLiter implements Liter {
  
  private final String value;
  private final CodePosition codePos;
  
  public BoolLiter(String value, CodePosition codePos) {
    this.value = value;
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    return BaseType.typeBool;
  }

  @Override
  public String getString() {
    return value;
  }

}
