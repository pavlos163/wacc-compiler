package compiler.assignables;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.types.Type;

public class Variable implements AssignLHS, Expr {
  
  public Variable() {
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type getType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CodePosition getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

}
