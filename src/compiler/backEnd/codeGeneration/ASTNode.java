package compiler.backEnd.codeGeneration;

import compiler.frontEnd.semanticCheck.ReturnableType;

public interface ASTNode extends ReturnableType {
  
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor);
  
}