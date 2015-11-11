package compiler.literals;

import compiler.CodePosition;
import compiler.expressions.Expr;
import compiler.semanticCheck.ReturnableType;
import compiler.types.PairType;
import compiler.types.Type;

public class PairLiter implements Liter {
  
  private final Expr fst;
  private final Expr snd;
  private final CodePosition codePos;
  
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
  public ReturnableType getType() {
    return new PairType((Type) fst.getType(), (Type) snd.getType());
  }

  @Override
  public String getString() {
    return null;
  }

}
