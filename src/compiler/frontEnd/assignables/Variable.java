package compiler.frontEnd.assignables;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.symbolTable.Identifier;
import compiler.frontEnd.symbolTable.SymbolTable;
import compiler.frontEnd.types.Type;

public class Variable implements AssignLHS, Expr {
  
  private final String name;
  private final SymbolTable<Identifier> scope;
  private final CodePosition codePos;
  
  public Variable(String name, SymbolTable<Identifier> scope, 
       CodePosition codePos) {
    this.name = name;
    this.scope = scope;
    this.codePos = codePos;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Type getType() {
    return scope.lookUpAll(name).getType();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public SymbolTable<Identifier> getScope() {
    return scope;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
