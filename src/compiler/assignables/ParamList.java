package compiler.assignables;

import java.util.List;

import compiler.CodePosition;
import compiler.semanticCheck.ReturnableType;

public class ParamList implements ReturnableType {
  
  private final List<Param> parameters;
  private final CodePosition codePos;
  
  public ParamList(List<Param> parameters, CodePosition codePos) {
    this.parameters = parameters;
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public List<Param> getParameters() {
    return parameters;
  }

}
