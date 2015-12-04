package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.frontEnd.expressions.Expr;

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

}
