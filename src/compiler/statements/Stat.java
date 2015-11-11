package compiler.statements;

import compiler.CodePosition;

public abstract class Stat {
  
  protected final CodePosition codePos;
  
  public Stat(CodePosition codePos) {
    this.codePos = codePos;
  }
  
  public CodePosition getCodePosition() {
    return codePos;
  }
  
}
