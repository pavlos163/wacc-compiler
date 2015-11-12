package compiler.expressions;

import compiler.semanticCheck.ReturnableType;

public interface Expr extends ReturnableType {
  
  ReturnableType getType();
  
}
