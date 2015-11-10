package compiler.assignables;

import compiler.semanticCheck.ReturnableType;

public interface Assignable {
  
  public String getName();
    
  public ReturnableType getType();
  
}