package compiler.assignables;

import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface AssignLHS extends AssignRHS {
  
  public String getName();
    
  public Type getType();
  
}
