package compiler.expressions;

import compiler.CodePosition;
import compiler.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.literals.Liter;
import compiler.types.Type;

public class ValueExpr implements Expr {
  
  private final Liter literal;
  private final CodePosition codePos;
  
  public ValueExpr(Liter literal, CodePosition codePos) {
    this.literal = literal;
    this.codePos = codePos;
  }

  @Override
  public Type getType() {
    return literal.getType();
  }
  
  public String getString() {
    return literal.getString();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public Liter getLiter() {
    return literal;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
