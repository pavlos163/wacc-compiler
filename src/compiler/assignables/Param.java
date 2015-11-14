package compiler.assignables;

import compiler.CodePosition;
import compiler.semanticCheck.ReturnableType;
import compiler.symbolTable.Identifier;
import compiler.symbolTable.SymbolTable;
import compiler.types.Type;

public class Param implements ReturnableType {
  
  private final Type type;
  private final String ident;
  private final CodePosition codePos;
  private final SymbolTable<Identifier> scope;
  
  
  public Param(String ident, SymbolTable<Identifier> scope, Type type, 
      CodePosition codePos) {
    this.ident = ident;
    this.scope = scope;
    this.type = type;
    this.codePos = codePos;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public Type getType() {
    return type;
  }
  
  public String getIdent() {
    return ident;
  }

  public SymbolTable<Identifier> getScope() {
    return scope;
  }
}
