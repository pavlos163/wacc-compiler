package compiler.frontEnd.assignables;

import java.util.List;

import compiler.CodePosition;
import compiler.frontEnd.semanticCheck.ReturnableType;
import compiler.frontEnd.statements.Stat;
import compiler.frontEnd.types.Type;

public class Function implements ReturnableType {
  
  private final String ident;
  private final Stat stat;
  private final List<Param> parameters;
  private final CodePosition codePos;
  private final Type returnType;
  
  public Function(Type type, String ident, List<Param> parameters,
      Stat stat, CodePosition codePos) {
    this.returnType = type;
    this.ident = ident;
    this.parameters = parameters;
    this.stat = stat;
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public List<Param> getParameters() {
    return this.parameters;
  }
  
  public Type getReturnType() {
    return returnType;
  }
  
  public String getIdent() {
    return ident;
  }
  
  public Stat getStatements() {
    return stat;
  }
  
}
