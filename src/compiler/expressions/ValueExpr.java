package compiler.expressions;

import compiler.CodePosition;
import compiler.literals.Liter;
import compiler.semanticCheck.ReturnableType;

public class ValueExpr implements Expr {
  
  private final Liter literal;
  private final CodePosition codePos;
  
  public ValueExpr(Liter literal, CodePosition codePos) {
    this.literal = literal;
    this.codePos = codePos;
  }

  @Override
  public ReturnableType getType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CodePosition getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

}
