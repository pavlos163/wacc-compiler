package compiler.assignables;

import java.util.Iterator;
import java.util.List;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.semanticCheck.ReturnableType;

public class ArgList implements ReturnableType, Iterable<Expr> {
  
  private final List<Expr> arguments;
  private final CodePosition codePos;
  
  public ArgList(List<Expr> expressions, CodePosition codePos) {
    this.arguments = expressions;
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
  
  public int numberOfArguments() {
    return arguments.size();
  }
  
  public List<Expr> getArguments() {
    return arguments;
  }
}
