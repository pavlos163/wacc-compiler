package compiler.assignables;

import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface AssignLHS extends ReturnableType {
  
  public String getName();
    
  public Type getType();
}