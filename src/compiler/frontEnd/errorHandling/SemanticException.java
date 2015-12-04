package compiler.frontEnd.errorHandling;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SemanticException extends ParseCancellationException {
  
  private final String errorMessage;
  
  public SemanticException(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  @Override
  public String getMessage() {
    return errorMessage;
  }
}
