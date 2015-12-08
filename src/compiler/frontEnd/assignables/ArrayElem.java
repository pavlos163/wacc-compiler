package compiler.frontEnd.assignables;

import java.util.List;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.literals.Liter;
import compiler.frontEnd.symbolTable.Identifier;
import compiler.frontEnd.symbolTable.SymbolTable;
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

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
  
  public List<Expr> getExpressions() {
    return exprs;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
