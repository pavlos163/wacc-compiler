package compiler.assignables;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.symbolTable.Identifier;
import compiler.symbolTable.SymbolTable;
import compiler.types.PairType;
import compiler.types.Type;

public class Second implements AssignLHS {
  
  private final AssignLHS expr;
  private final CodePosition codePos;
  private final SymbolTable<Identifier> scope;
  
  public Second(AssignLHS expr, SymbolTable<Identifier> scope, CodePosition codePos) {
    this.expr = expr;
    this.scope = scope;
    this.codePos = codePos;
    
    checkErrors();
  }
  
  public void checkErrors() {
    if (!(expr.getType() instanceof PairType)) {
      throw new SemanticException("At " + codePos + ". Must be of type"
          + " pair. Actual type: " + expr.getType());
    }
  }

  public CodePosition getPosition() {
    return codePos;
  }
  
  @Override
  public String getName() {
    return expr.getName();
  }

  @Override
  public Type getType() {
    return ((PairType) scope.lookUpAll(getName()).getType()).getSnd();
  }

}
