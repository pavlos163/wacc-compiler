package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.frontEnd.semanticCheck.ReturnableType;

public abstract class Stat implements ReturnableType {
  
  protected final CodePosition codePos;
  
  public Stat(CodePosition codePos) {
    this.codePos = codePos;
  }
  
  public CodePosition getCodePosition() {
    return codePos;
  }
  
}