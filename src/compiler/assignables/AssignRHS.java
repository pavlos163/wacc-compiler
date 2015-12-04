package compiler.assignables;

import compiler.codeGeneration.ASTNode;
import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface AssignRHS extends ASTNode {
  
  public Type getType();
  
}