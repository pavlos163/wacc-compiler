package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.types.BaseType;

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
  
  public Expr getExpr() {
    return expression;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}