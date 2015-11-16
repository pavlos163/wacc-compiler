package compiler.expressions;

import compiler.assignables.AssignRHS;
import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface Expr extends ReturnableType, AssignRHS {
  
  Type getType();
  
}
