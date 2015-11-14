package compiler.assignables;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.symbolTable.Identifier;
import compiler.symbolTable.SymbolTable;
import compiler.types.PairType;
import compiler.types.Type;

public class First implements AssignLHS {
  
  private final AssignLHS expr;
  private final CodePosition codePos;
  private final SymbolTable<Identifier> scope; 
  
  public First(AssignLHS expr, CodePosition codePos, SymbolTable<Identifier> scope) {
    this.expr = expr;
    this.codePos = codePos;
    this.scope = scope;
    
    if (!isPairType()) {
      throw new SemanticException("Type Mismatch error");
    }
  }
  
  public boolean isPairType() {
    return expr.getType() instanceof PairType;
  }

  @Override
  public String getName() {
    return expr.getName();
  }

  @Override
  public Type getType() {
    return ((PairType) scope.lookUpAll(getName()).getType()).getFst();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
