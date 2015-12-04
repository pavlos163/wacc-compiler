package compiler.frontEnd.statements;

import java.util.LinkedList;
import java.util.List;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.ASTNode;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;

public class StatList extends Stat {
  
  private final List<Stat> statements;

  public StatList(List<Stat> statements, CodePosition codePos) {
    super(codePos);
    if (statements == null) {
      this.statements = new LinkedList<>();
    }
    else {
      this.statements = statements;
    }
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
  public List<ASTNode> getChildren() {
    List<ASTNode> children = new LinkedList<ASTNode>();
    children.addAll(statements);
    return children;
  }
}
