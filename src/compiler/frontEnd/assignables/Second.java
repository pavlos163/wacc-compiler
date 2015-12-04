package compiler.frontEnd.assignables;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.symbolTable.Identifier;
import compiler.frontEnd.symbolTable.SymbolTable;
import compiler.frontEnd.types.PairType;
import compiler.frontEnd.types.Type;

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
      throw new SemanticException("At: " + codePos + " expression must be"
          + " of type pair. Actual type: " + expr.getType());
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
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
