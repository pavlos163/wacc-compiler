package compiler.literals;

import compiler.CodePosition;
import compiler.errorHandling.SyntaxException;
import compiler.semanticCheck.ReturnableType;
import compiler.types.BaseType;

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
  public ReturnableType getType() {
    switch(value) {
    case "MUL":
      return BaseType.typeBool;
    case "DIV":
      return BaseType.typeInt;
    case "MOD":
      return BaseType.typeInt;
    case "PLUS":
      return BaseType.typeInt;
    case "MINUS":
      return BaseType.typeInt;
    case "GREATER":
      return BaseType.typeBool;
    case "GREATER_OR_EQUAL":
      return BaseType.typeBool;
    case "LESS":
      return BaseType.typeBool;
    case "LESS_OR_EQUAL":
      return BaseType.typeBool;
    case "EQUAL":
      return BaseType.typeBool;
    case "NOT_EQUAL":
      return BaseType.typeBool;
    case "AND":
      return BaseType.typeBool;
    case "OR":
      return BaseType.typeBool;
    default:
      return null;
    }
  }

  @Override
  public String getString() {
    switch(value) {
    case "MUL":
      return "*";
    case "DIV":
      return "/";
    case "MOD":
      return "%";
    case "PLUS":
      return "+";
    case "MINUS":
      return "-";
    case "GREATER":
      return ">";
    case "GREATER_OR_EQUAL":
      return ">=";
    case "LESS":
      return "<";
    case "LESS_OR_EQUAL":
      return "<=";
    case "EQUAL":
      return "==";
    case "NOT_EQUAL":
      return "!=";
    case "AND":
      return "&&";
    case "OR":
      return "||";
    default:
      return null;
    }
  }
  
  private void checkBinaryOper(String value) throws SyntaxException {
    switch(value) {
    case "MUL":
    case "DIV":
    case "MOD":
    case "PLUS":
    case "MINUS":
    case "GREATER":
    case "GREATER_OR_EQUAL":
    case "LESS":
    case "LESS_OR_EQUAL":
    case "EQUAL":
    case "NOT_EQUAL":
    case "AND":
    case "OR":
      break;
    default:
      throw new SyntaxException("Invalid binary operator at " + codePos + ".");
    }
  }
  
}
