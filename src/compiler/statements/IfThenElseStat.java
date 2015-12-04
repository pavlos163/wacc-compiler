package compiler.statements;

import compiler.CodePosition;
import compiler.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.expressions.Expr;

public class IfThenElseStat extends StatWithCond {
  
  private final Stat ifBody, elseBody;

  public IfThenElseStat(Expr condition, Stat ifBody,
      Stat elseBody, CodePosition codePos) {
    super(condition, codePos);
    this.ifBody = ifBody;
    this.elseBody = elseBody;
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
