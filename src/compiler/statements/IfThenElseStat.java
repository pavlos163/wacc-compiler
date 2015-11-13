package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.BaseType;

public class IfThenElseStat extends Stat {
  
  private final Stat ifBody, elseBody;
  private final Expr condition;

  public IfThenElseStat(Expr condition, Stat ifBody,
      Stat elseBody, CodePosition codePos) {
    super(codePos);
    this.condition = condition;
    this.ifBody = ifBody;
    this.elseBody = elseBody;
    checkErrors(condition);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  private void checkErrors(Expr condition) {
    if (!condition.getType().equals(BaseType.typeBool)) {
      throw new SemanticException("Condition must be of type boolean.");
    }
  }

}
