package compiler.frontEnd.assignables;

import compiler.frontEnd.types.Type;

public interface AssignLHS extends AssignRHS {
  
  public String getName();
    
  public Type getType();
      
}
