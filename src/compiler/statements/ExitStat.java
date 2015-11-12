package compiler.statements;

import compiler.CodePosition;
import compiler.expressions.Expr;

public class ExitStat extends Stat {
  
  private final Expr expression;
  
  public ExitStat(Expr expression, CodePosition codePos) {
    super(codePos);
    this.expression = expression;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
