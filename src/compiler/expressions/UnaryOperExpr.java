package compiler.expressions;

import compiler.CodePosition;
import compiler.literals.UnaryOperLiter;
import compiler.semanticCheck.ReturnableType;

public class UnaryOperExpr implements Expr {
  
  final private UnaryOperLiter unOpLtr;
  final private Expr expression;
  final private CodePosition codePos;
  
  public UnaryOperExpr(UnaryOperLiter unOpLtr, 
      Expr expression, CodePosition codePos) {
    this.unOpLtr = unOpLtr;
    this.expression = expression;
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
