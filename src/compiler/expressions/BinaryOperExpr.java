package compiler.expressions;

import compiler.CodePosition;
import compiler.literals.BinaryOperLiter;
import compiler.semanticCheck.ReturnableType;

public class BinaryOperExpr implements Expr {
  
  private final BinaryOperLiter binOpLtr;
  private Expr exprLeft;
  private Expr exprRight;
  private CodePosition codePos;
  
  public BinaryOperExpr(BinaryOperLiter binOpLtr, 
      Expr exprLeft, Expr exprRight, CodePosition codePos) {
    this.binOpLtr = binOpLtr;
    this.exprLeft = exprLeft;
    this.exprRight = exprRight;
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
