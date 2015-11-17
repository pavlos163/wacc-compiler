package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.BaseType;

public abstract class StatWithCond extends Stat {
  
  private final Expr condition;
  
  public StatWithCond(Expr condition, CodePosition codePos) {
    super(codePos);
    this.condition = condition;
  }

  protected void checkErrors(Expr condition) {
    if (!condition.getType().equals(BaseType.typeBool)) {
      throw new SemanticException("At " + codePos.toString()
          + " condition must be of type boolean."
          + " Actual type: " + condition.getType());
    }
  }
  
  public Expr getCondition() {
    return condition;
  }
  
}
