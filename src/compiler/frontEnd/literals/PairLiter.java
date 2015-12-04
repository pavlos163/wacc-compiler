package compiler.frontEnd.literals;

import compiler.CodePosition;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.types.PairType;
import compiler.frontEnd.types.Type;

public class PairLiter implements Liter {
  
  private final Expr fst;
  private final Expr snd;
  private final CodePosition codePos;
  
  public PairLiter(CodePosition codePos) {
    this.fst = null;
    this.snd = null;
    this.codePos = codePos;
  }
  
  public PairLiter(Expr fst, Expr snd, CodePosition codePos) {
    this.fst = fst;
    this.snd = snd;
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    return new PairType(checkType(fst), (Type) checkType(snd));
  }
  
  // What if the expr is null? That happens when we 
  // pass a pair as a fst or snd.
  public Type checkType(Expr expr) {
    if (expr == null) {
      return null;
    }
    return (Type) expr.getType();
  }

  @Override
  public String getString() {
    return null;
  }

}
