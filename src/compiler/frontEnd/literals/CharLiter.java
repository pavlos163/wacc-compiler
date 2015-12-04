package compiler.frontEnd.literals;

import compiler.CodePosition;
import compiler.frontEnd.errorHandling.SyntaxException;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

public class CharLiter implements Liter {
  
  private final String value;
  private final CodePosition codePos;
  
  public CharLiter(String value, CodePosition codePos) throws SyntaxException {
    this.value = value;
    this.codePos = codePos;
    checkEscapedCharacter(value);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    return BaseType.typeChar;
  }

  @Override
  public String getString() {
    return value;
  }
  
  private void checkEscapedCharacter(String value) throws SyntaxException {
    if (value.length() == 3 && (value.charAt(1) == '\\' 
        || value.charAt(1) == '\'' || value.charAt(1) == '"')) {
      throw new SyntaxException
        ("At: " + codePos.toString() + " this character should be escaped");
    }
    else if (value.charAt(1) == '\\') {
      switch (value.charAt(2)) {
      case ('0'):
      case ('b'):
      case ('t'):
      case ('n'):
      case ('f'):
      case ('r'):
      case ('\\'):
      case ('\''):
      case ('"'):
        break;
      default:
        throw new SyntaxException
          ("At: " + codePos.toString() + " invalid escaped character");
      }
    }
  }

}
