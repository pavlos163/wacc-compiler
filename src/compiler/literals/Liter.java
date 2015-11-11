package compiler.literals;

import compiler.semanticCheck.ReturnableType;

public interface Liter extends ReturnableType {
  
  public ReturnableType getType();
  
  public String getString();
    
}