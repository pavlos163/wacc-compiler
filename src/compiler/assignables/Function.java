package compiler.assignables;

import java.util.List;

import compiler.CodePosition;
import compiler.semanticCheck.ReturnableType;
import compiler.statements.Stat;
import compiler.types.Type;

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
