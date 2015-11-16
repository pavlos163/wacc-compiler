package compiler.literals;

import compiler.CodePosition;
import compiler.errorHandling.SyntaxException;
import compiler.types.BaseType;
import compiler.types.Type;

public class UnaryOperLiter implements Liter {
      
  private final String value;
  private final CodePosition codePos;
  
  public UnaryOperLiter(String value, CodePosition codePos) throws SyntaxException {
    this.value = value;
    this.codePos = codePos;
    checkUnaryOper(value);
  }
  
  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    switch(value) {
    case "!":
      return BaseType.typeBool;
    case "-":
      return BaseType.typeInt;
    case "len":
      return BaseType.typeInt;
    case "ord":
      return BaseType.typeInt;
    case "chr":
      return BaseType.typeChar;
    default:
      return null;
    }
  }

  @Override
  public String getString() {
    return value;
  }
  
  private void checkUnaryOper(String value) throws SyntaxException {
    switch(value) {
    case "!":
    case "-":
    case "len":
    case "ord":
    case "chr":
      break;
    default:
      throw new SyntaxException("At " + codePos.toString() + ". Invalid "
          + "unary operator."); 
    }
  }
  
}
