package compiler.frontEnd.errorHandling;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SyntaxException extends ParseCancellationException {
  
  private final String errorMessage;
  
  public SyntaxException(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  @Override
  public String getMessage() {
    return this.errorMessage;
  }
}
