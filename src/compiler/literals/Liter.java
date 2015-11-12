package compiler.literals;

import compiler.semanticCheck.ReturnableType;
import compiler.types.Type;

public interface Liter extends ReturnableType {
  
  public Type getType();
  
  public String getString();
    
}