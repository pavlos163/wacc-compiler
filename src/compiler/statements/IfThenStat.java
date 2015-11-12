package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.BaseType;

public class IfThenStat extends Stat {
  
  private final Expr condition;
  private final Stat ifBody;
  
  public IfThenStat(Expr condition, Stat ifBody, CodePosition codePos) {
    super(codePos);
    this.condition = condition;
    this.ifBody = ifBody;
    checkErrors(condition);
  }

  @Override
  public CodePosition getPosition() {
    // TODO Auto-generated method stub
    return null;
  }
  
  private void checkErrors(Expr condition) {
    if (!condition.getType().equals(BaseType.typeBool)) {
      throw new SemanticException("Condition must be of type boolean.");
    }
  }
  // POSSIBLE DUPLICATION REPLACEMENT HERE.

}
