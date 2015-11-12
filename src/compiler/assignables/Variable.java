package compiler.assignables;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.semanticCheck.ReturnableType;

public class Variable implements AssignLHS, Expr {
  
  public Variable() {
    
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
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
