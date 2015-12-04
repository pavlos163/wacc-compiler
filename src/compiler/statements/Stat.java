package compiler.statements;

import compiler.CodePosition;
import compiler.codeGeneration.ASTNode;
import compiler.semanticCheck.ReturnableType;

public abstract class Stat implements ASTNode {
  
  protected final CodePosition codePos;
  
  public Stat(CodePosition codePos) {
    this.codePos = codePos;
  }
  
  public CodePosition getCodePosition() {
    return codePos;
  }
  
}