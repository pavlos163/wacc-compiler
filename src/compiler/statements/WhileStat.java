package compiler.statements;

import compiler.CodePosition;
import compiler.expressions.Expr;

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

}