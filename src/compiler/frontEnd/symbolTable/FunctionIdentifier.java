package compiler.frontEnd.symbolTable;

import java.util.List;

import compiler.CodePosition;
import compiler.frontEnd.types.Type;

public class FunctionIdentifier extends Identifier {
  
  private final List<Type> typesOfParameters;
  
  public FunctionIdentifier(Type type, List<Type> typesOfParameters, 
      CodePosition codePos) {
    super(type, codePos);
    this.typesOfParameters = typesOfParameters;
  }
  
  public List<Type> getParamTypes() {
    return typesOfParameters;
  }
}
