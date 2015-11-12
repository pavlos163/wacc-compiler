package compiler.expressions;

import compiler.types.Type;

public interface Expr extends ReturnableType {
  
  Type getType();
  
}
