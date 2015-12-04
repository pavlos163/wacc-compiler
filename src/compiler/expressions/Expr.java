package compiler.expressions;

import compiler.assignables.AssignRHS;
import compiler.codeGeneration.ASTNode;
import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface Expr extends ASTNode, AssignRHS {
  
  Type getType();
  
}
