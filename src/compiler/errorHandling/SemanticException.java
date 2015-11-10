package compiler.errorHandling;

public class SemanticException extends Exception {
  
  private final String errorMessage;
  
  public SemanticException(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  @Override
  public String getMessage() {
    return errorMessage;
  }
}
