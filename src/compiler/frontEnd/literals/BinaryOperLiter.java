package compiler.frontEnd.literals;

import compiler.CodePosition;
import compiler.frontEnd.errorHandling.SyntaxException;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

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
    case "/":
    case "%":
    case "+":
    case "-":
      return BaseType.typeInt;
    case ">":     
    case ">=":    
    case "<":
    case "<=":   
    case "==":
    case "!=":
    case "&&":
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
      throw new SyntaxException("At: " + codePos + 
          " invalid binary operator");
    }
  }
}
