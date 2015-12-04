package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.ASTNode;

public abstract class Stat implements ASTNode {
  
  protected final CodePosition codePos;
  
  public Stat(CodePosition codePos) {
    this.codePos = codePos;
  }
  
  public CodePosition getCodePosition() {
    return codePos;
  }
  
}