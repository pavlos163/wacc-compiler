package compiler.codeGeneration;

import compiler.semanticCheck.ReturnableType;

public interface ASTNode extends ReturnableType {
  
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor);
  
}