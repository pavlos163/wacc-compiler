package compiler.statements;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.types.ArrType;
import compiler.types.PairType;

public class FreeStat extends Stat {
  
  private final Expr heapItem;
  
  public FreeStat(Expr heapItem, CodePosition codePos) {
    super(codePos);
    this.heapItem = heapItem;
    checkErrors(heapItem);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  private void checkErrors(Expr heapItem) {
    if (!(heapItem.getType().equals(new ArrType(null))
        || heapItem.getType().equals(new PairType(null, null)))) {
      throw new SemanticException("At " + codePos.toString() + 
          ". Item freed must be heap allocated, therefore it must be a"
          + " pair or an array. Actual type: " + heapItem.getType());
    }
  }
  
}
