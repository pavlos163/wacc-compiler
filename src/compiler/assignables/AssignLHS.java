package compiler.assignables;

import compiler.semanticCheck.ReturnableType;

public interface AssignLHS {
  
  public String getName();
    
  public ReturnableType getType();
  
}