package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.BaseType;

public class ExitStat extends Stat {
  
  private final Expr expression;
  
  public ExitStat(Expr expression, CodePosition codePos) {
    super(codePos);
    this.expression = expression;
    checkErrors(expression);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  private void checkErrors(Expr expression) {
    if (!expression.getType().equals(BaseType.typeInt)) {
      throw new SemanticException("At: " + codePos.toString() +
          " exit code must be of type int. Actual type: "
          + expression.getType());
    }
  }

}