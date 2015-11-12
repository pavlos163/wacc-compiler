package compiler.expressions;

import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface Expr extends ReturnableType {
  
  Type getType();
  
}
