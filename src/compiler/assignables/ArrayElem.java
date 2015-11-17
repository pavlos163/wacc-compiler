package compiler.assignables;

import java.util.List;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.literals.Liter;
import compiler.symbolTable.Identifier;
import compiler.symbolTable.SymbolTable;
import compiler.types.ArrType;
import compiler.types.BaseType;
import compiler.types.Type;

public class ArrayElem implements AssignLHS, Liter {
  
  private final String ident;
  private final List<Expr> exprs;
  private final CodePosition codePos;
  private final Type type;
  private final SymbolTable<Identifier> scope;
  
  public ArrayElem(String ident, List<Expr> exprs, 
      SymbolTable<Identifier> scope, CodePosition codePos) {
    this.ident = ident;
    this.exprs = exprs;
    this.scope = scope;
    this.codePos = codePos;
    
    Identifier identifier = scope.lookUpAll(ident);
    ArrType arrayType = (ArrType) identifier.getType();
    this.type = arrayType.getType();
    checkErrors();
  }
  
  public void checkErrors() {
    for (Expr expr : exprs) {
      if (!expr.getType().equals(BaseType.typeInt)) {
        throw new SemanticException("At: " + codePos + " element must be of "
            + " type int. Actual type: " + expr.getType());
      }
    }
  }
  
  @Override
  public String getName() {
    return ident;
  }

  @Override
  public Type getType() {
    return type;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  @Override
  public String getString() {
    return null; // Not needed.
  }
  
  public SymbolTable<Identifier> getScope() {
    return scope;
  }

}
