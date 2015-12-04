package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.expressions.Expr;

public class WhileStat extends StatWithCond {
  
  private final Stat whileBody;

  public WhileStat(Expr condition, Stat whileBody, CodePosition codePos) {
    super(condition, codePos);
    this.whileBody = whileBody;
    checkErrors(condition);
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