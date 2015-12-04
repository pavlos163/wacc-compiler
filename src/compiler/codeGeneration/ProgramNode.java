package compiler.codeGeneration;

import java.util.List;

import compiler.CodePosition;
import compiler.assignables.Function;
import compiler.statements.Stat;

public class ProgramNode implements ASTNode {

  private List<Function> func;
  private Stat stat;
  private CodePosition codePos;
  
  public ProgramNode(List func, Stat stat, CodePosition codePos) {
    this.func = func;
    this.stat = stat;
    this.codePos = codePos;
  }
  
  public Stat getStatements() {
    return stat;
  }
  
  public List<Function> getFunctions() {
    return func;
  }
  
  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
