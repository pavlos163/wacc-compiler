package compiler.errorHandling;

public class SemanticError extends Exception {
  
  private final String errorMessage;
  
  public SemanticError(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  @Override
  public String getMessage() {
    return errorMessage;
  }
}
