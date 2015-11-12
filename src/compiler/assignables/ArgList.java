package compiler.assignables;

import java.util.Iterator;
import java.util.List;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.semanticCheck.ReturnableType;

public class ArgList implements ReturnableType, Iterable<Expr> {
  
  private final List<Expr> expressions;
  private final CodePosition codePos;
  
  public ArgList(List<Expr> expressions, CodePosition codePos) {
    this.expressions = expressions;
    this.codePos = codePos;
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
