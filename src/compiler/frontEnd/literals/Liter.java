package compiler.frontEnd.literals;

import compiler.frontEnd.semanticCheck.ReturnableType;
import compiler.frontEnd.types.Type;

public interface Liter extends ReturnableType {
  
  public Type getType();
  
  public String getString();
    
}