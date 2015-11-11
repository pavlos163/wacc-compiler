package compiler.assignables;

import java.util.Iterator;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.semanticCheck.ReturnableType;

public class ArgList implements ReturnableType, Iterable<Expr> {
  
  public ArgList() {
    
  }

  @Override
  public CodePosition getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterator<Expr> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

}
