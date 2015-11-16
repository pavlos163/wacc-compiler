package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.BaseType;

public abstract class StatWithCond extends Stat {
  
  public StatWithCond(CodePosition codePos) {
    super(codePos);
  }

  protected void checkErrors(Expr condition) {
    if (!condition.getType().equals(BaseType.typeBool)) {
      throw new SemanticException("At " + codePos.toString()
          + ". Condition must be of type boolean."
          + " Actual type: " + condition.getType());
    }
  }
}
