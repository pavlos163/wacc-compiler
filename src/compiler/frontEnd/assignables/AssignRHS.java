package compiler.frontEnd.assignables;

import compiler.frontEnd.semanticCheck.ReturnableType;
import compiler.frontEnd.types.Type;

public interface AssignRHS extends ReturnableType {
  
  public Type getType();
  
}