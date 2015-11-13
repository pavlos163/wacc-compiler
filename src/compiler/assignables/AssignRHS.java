package compiler.assignables;

import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface AssignRHS extends ReturnableType {
  
  public Type getType();
  
}