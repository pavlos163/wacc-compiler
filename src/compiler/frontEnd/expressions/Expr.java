package compiler.frontEnd.expressions;

import compiler.frontEnd.assignables.AssignRHS;
import compiler.frontEnd.semanticCheck.ReturnableType;
import compiler.frontEnd.types.Type;

public interface Expr extends ReturnableType, AssignRHS {
  
  Type getType();
  
}
