package compiler.assignables;

import java.util.Iterator;
import java.util.Vector;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.semanticCheck.ReturnableType;

public class ArgList implements ReturnableType, Iterable<Expr> {
  
  private final Vector<Expr> arguments;
  private final CodePosition codePos;
  
  public ArgList(Vector<Expr> arguments, CodePosition codePos) {
    this.arguments = arguments;
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Iterator<Expr> iterator() {
    return arguments.iterator();
  }

}
