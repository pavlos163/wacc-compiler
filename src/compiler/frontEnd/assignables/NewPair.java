package compiler.frontEnd.assignables;

import java.util.LinkedList;
import java.util.List;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.types.PairType;
import compiler.frontEnd.types.Type;

public class NewPair implements AssignRHS {
  
  private final Expr first, second;
  private final CodePosition codePos;
  
  public NewPair(Expr first, Expr second, CodePosition codePos) {
    this.first = first;
    this.second = second;
    this.codePos = codePos;
  }

  @Override
  public Type getType() {
    return new PairType(first.getType(), second.getType());
  }
  
  public CodePosition getPosition() {
    return codePos;
  }
  
  public Expr getFirst() {
    return first;
  }
  
  public Expr getSecond() {
    return second;
  }
  
  public List<Expr> getExprs() {
    List<Expr> expressions = new LinkedList<Expr>();
    expressions.add(first);
    expressions.add(second);
    return expressions;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
  
}
