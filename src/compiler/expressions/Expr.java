package compiler.expressions;

import compiler.semanticCheck.ReturnableType;

public interface Expr {
  
  ReturnableType getType();
  
}
