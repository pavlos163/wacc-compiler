package compiler.statements;

import compiler.CodePosition;
import compiler.expressions.Expr;

public class PrintStat extends Stat {
  
  private final Expr message;

  public PrintStat(Expr message, CodePosition codePos) {
    super(codePos);
    this.message = message;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
