package compiler.literals;

import compiler.CodePosition;
import compiler.errorHandling.SyntaxException;
import compiler.types.BaseType;
import compiler.types.Type;

public class BinaryOperLiter implements Liter {
      
  private final String value;
  private final CodePosition codePos;
  
  public BinaryOperLiter(String value, CodePosition codePos) throws SyntaxException {
    this.value = value;
    this.codePos = codePos;
    checkBinaryOper(value);
  }
  
  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    switch(value) {
    case "*":
      return BaseType.typeInt;
    case "/":
      return BaseType.typeInt;
    case "%":
      return BaseType.typeInt;
    case "+":
      return BaseType.typeInt;
    case "-":
      return BaseType.typeInt;
    case ">":
      return BaseType.typeBool;
    case ">=":
      return BaseType.typeBool;
    case "<":
      return BaseType.typeBool;
    case "<=":
      return BaseType.typeBool;
    case "EQUAL":
      return BaseType.typeBool;
    case "!=":
      return BaseType.typeBool;
    case "&&":
      return BaseType.typeBool;
    case "||":
      return BaseType.typeBool;
    default:
      return null;
    }
  }

  @Override
  public String getString() {
    return value;
  }
  
  private void checkBinaryOper(String value) throws SyntaxException {
    switch(value) {
    case "*":
    case "/":
    case "%":
    case "+":
    case "-":
    case ">":
    case ">=":
    case "<":
    case "<=":
    case "==":
    case "!=":
    case "&&":
    case "||":
      break;
    default:
      throw new SyntaxException("At " + codePos.toString() + 
          ". Invalid binary operator.");
    }
  }
}
