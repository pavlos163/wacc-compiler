package compiler.frontEnd.assignables;

import compiler.backEnd.codeGeneration.ASTNode;
import compiler.frontEnd.types.Type;

public interface AssignRHS extends ASTNode {
  
  public Type getType();
  
}