package compiler.statements;

import compiler.CodePosition;
import compiler.expressions.Expr;

public class ReturnStat extends Stat {
  
  private final String method;
  private final Expr returnedItem;
  
  public ReturnStat(String method, Expr returnedItem, CodePosition codePos) {
    super(codePos);
    this.method = method;
    this.returnedItem = returnedItem;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public String getMethod() {
    return method;
  }

}
