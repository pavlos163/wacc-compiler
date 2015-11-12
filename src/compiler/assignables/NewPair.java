package compiler.assignables;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.types.PairType;
import compiler.types.Type;

public class NewPair implements AssignRHS {
  
  private final Expr first,second;
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

}
