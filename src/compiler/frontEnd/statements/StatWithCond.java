package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.types.BaseType;

public abstract class StatWithCond extends Stat {
  
  private final Expr condition;
  
  public StatWithCond(Expr condition, CodePosition codePos) {
    super(codePos);
    this.condition = condition;
  }

  protected void checkErrors(Expr condition) {
    if (!condition.getType().equals(BaseType.typeBool)) {
      throw new SemanticException("At: " + codePos.toString()
          + " condition must be of type boolean."
          + " Actual type: " + condition.getType());
    }
  }
  
  public Expr getCondition() {
    return condition;
  }
  
}
