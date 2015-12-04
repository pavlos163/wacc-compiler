package compiler.statements;

import compiler.CodePosition;
import compiler.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.expressions.Expr;

public class PrintlnStat extends Stat {
  
  private final Expr message;

  public PrintlnStat(Expr message, CodePosition codePos) {
    super(codePos);
    this.message = message;
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
