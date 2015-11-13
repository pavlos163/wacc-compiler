package compiler.literals;

import compiler.CodePosition;
import compiler.errorHandling.SyntaxException;
import compiler.semanticCheck.ReturnableType;
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
    case "NOT":
      return BaseType.typeBool;
    case "NEGATIVE":
      return BaseType.typeInt;
    case "LEN":
      return BaseType.typeInt;
    case "ORD":
      return BaseType.typeInt;
    case "CHR":
      return BaseType.typeChar;
    default:
      return null;
    }
  }

  @Override
  public String getString() {
    switch (value) {
    case "NOT":
      return "!";
    case "NEGATIVE":
      return "-";
    case "LEN":
      return "len";
    case "ORD":
      return "ord";
    case "CHR":
      return "chr";
    default:
      return null;
    }
  }
  
  private void checkUnaryOper(String value) throws SyntaxException {
    switch(value) {
    case "NOT":
    case "NEGATIVE":
    case "LEN":
    case "ORD":
    case "CHR":
      break;
    default:
      throw new SyntaxException("At " + codePos.toString() + ". Invalid "
          + "unary operator."); 
    }
  }
  
}
