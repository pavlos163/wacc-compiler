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
    
    if (!isPair()) {
      throw new SemanticException("Type mismatch error " + codePos);
    }
  }

  public CodePosition getPosition() {
    return codePos;
  }
  
  public boolean isPair() {
    return expr.getType() instanceof PairType;
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
