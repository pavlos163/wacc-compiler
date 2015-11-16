package compiler.statements;

import compiler.CodePosition;
import compiler.assignables.AssignLHS;
import compiler.errorHandling.SemanticException;
import compiler.types.ArrType;
import compiler.types.BaseType;

public class ReadStat extends Stat {
  
  private final AssignLHS readItem;

  public ReadStat(AssignLHS readItem, CodePosition codePos) {
    super(codePos);
    this.readItem = readItem;
    checkErrors(readItem);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  private void checkErrors(AssignLHS readItem) {
    if (!readItem.getType().toString().equals("Int") 
        && !readItem.getType().toString().equals("Char")
        && (!isString(readItem))) {
      throw new SemanticException("At " + codePos.toString()  
          + ". Item to be read can only be an int, char or string."
          + " Actual type: " + readItem.getType());
    }
  }
  
  private boolean isString(AssignLHS readItem) {
    return readItem.getType().equals(new ArrType(BaseType.typeChar));
  }

}
