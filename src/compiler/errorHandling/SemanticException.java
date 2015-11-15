package compiler.errorHandling;

import org.antlr.v4.runtime.misc.ParseCancellationException;

public class SemanticException extends ParseCancellationException {
  
  private final String errorMessage;
  
  public SemanticException(String errorMessage) {
    this.errorMessage = errorMessage;
    System.exit(200);
  }
  
  @Override
  public String getMessage() {
    return errorMessage;
  }
}
