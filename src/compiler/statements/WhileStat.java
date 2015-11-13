package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.BaseType;

public class WhileStat extends Stat {
  
  private final Expr condition;
  private final Stat whileBody;

  public WhileStat(Expr condition, Stat whileBody, CodePosition codePos) {
    super(codePos);
    this.condition = condition;
    this.whileBody = whileBody;
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
