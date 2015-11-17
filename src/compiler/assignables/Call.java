package compiler.assignables;

import java.util.Iterator;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.expressions.Expr;
import compiler.symbolTable.FunctionIdentifier;
import compiler.symbolTable.SymbolTable;
import compiler.types.Type;

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

  private FunctionIdentifier giveIdentifier() {
    FunctionIdentifier fIdent = 
        (FunctionIdentifier) functions.lookUpAll(name);
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

}
