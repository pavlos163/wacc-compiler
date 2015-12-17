package compiler.frontEnd.assignables;

import java.util.Iterator;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.symbolTable.FunctionIdentifier;
import compiler.frontEnd.symbolTable.SymbolTable;
import compiler.frontEnd.types.Type;

public class Call implements AssignRHS {
  
  private final String name;
  private final ArgList argList;
  private final CodePosition codePos;
  private SymbolTable<FunctionIdentifier> functions;
  
  public Call(String name, ArgList argList, 
      SymbolTable<FunctionIdentifier> functions, CodePosition codePos) {
    this.name = name;
    this.argList = argList;
    this.codePos = codePos;
    this.functions = functions;
    
    // Do proper checks.
    if (lessNumOfArgs()) {
      throw new SemanticException
        ("At: " + codePos + " the number of arguments is smaller "
            + "than expected");
    }
    if (moreNumOfArgs()) {
      throw new SemanticException
        ("At: " + codePos + " the number of arguments is bigger "
            + "than expected");
    }
    if (incorrectTypes()) {
      throw new SemanticException("At: " + codePos + " the types of "
          + "parameters don't match");
    }
  }
  
  private boolean lessNumOfArgs() {
    FunctionIdentifier fIdent = giveIdentifier();
    if (fIdent == null) {
      return false;
    }
    if (fIdent.getParamTypes().size() > argList.numberOfArguments()) {
      return true;
    }
    return false;
  }
  
  private boolean moreNumOfArgs() {
    FunctionIdentifier fIdent = giveIdentifier();
    if (fIdent == null) {
      return false;
    }
    if (fIdent.getParamTypes().size() < argList.numberOfArguments()) {
      return true;
    }
    return false;
  }
  
  private boolean incorrectTypes() {
    FunctionIdentifier fIdent = giveIdentifier();
    if (fIdent == null) {
      return false;
    }
    Iterator<Expr> i = argList.iterator();
    Iterator<Type> j = fIdent.getParamTypes().iterator();
    
    while (i.hasNext() && j.hasNext()) {
      Expr expression = i.next();
      Type type = j.next();
      
      if (!type.equals(expression.getType())) {
        return true;
      }
    }
    return false;
  }
  
  private String getParamStr() {
    return "";
  }

  private FunctionIdentifier giveIdentifier() {
    String nameWithTypes = name + getParamStr();
    
    if (functions.lookUpAll(nameWithTypes) == null) {
      throw new SemanticException("At: " + codePos + " undeclared "
          + "function error: " + name);
    }
    FunctionIdentifier fIdent = 
        (FunctionIdentifier) functions.lookUpAll(nameWithTypes);
    return fIdent;
  }
  
  @Override
  public Type getType() {
    FunctionIdentifier fIdent = giveIdentifier();
    if (fIdent == null) {
      return null;
    }
    return fIdent.getType();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  public ArgList getArguments() {
    return argList;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
