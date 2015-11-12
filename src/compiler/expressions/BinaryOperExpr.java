package compiler.expressions;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.errorHandling.SyntaxException;
import compiler.literals.BinaryOperLiter;
import compiler.types.BaseType;
import compiler.types.Type;

public class BinaryOperExpr implements Expr {
  
  private final BinaryOperLiter binaryOp;
  private final Expr lhs,rhs;
  private final CodePosition codePos;
  
  public BinaryOperExpr(BinaryOperLiter binaryOp,Expr lhs, Expr rhs, 
      CodePosition codePos) throws SemanticException, SyntaxException {
    this.binaryOp = binaryOp;
    this.lhs = lhs;
    this.rhs = rhs;
    this.codePos = codePos;
    
    // Check whether the lhs and rhs expressions have the same type.
    // Otherwise throw a semantic exception.
    if (typeMissMatch()) {
      throw new SemanticException("Type MissMatch error at " + codePos.toString());
    }
  }

  private boolean typeMissMatch() {
    switch (this.binaryOp.getString()) {
    case "*":
    case "/":
    case "%":
    case "+":
    case "-":
      return checkForTypeError(BaseType.typeInt);
    case ">":
    case ">=":
    case "<":
    case "<=":
      return checkForTypeError(BaseType.typeInt,BaseType.typeChar);
    case "==":
    case "!=":
      return !this.lhs.getType().equals(this.rhs.getType());
    case "&&":
    case "||":
      return checkForTypeError(BaseType.typeBool);
    default:
      // Another error is causing that. However it is better to 
      // throw an error rather than producing a dysfunctional program.
      return false;
    }
  }
   
  private boolean checkForTypeError(BaseType ...types) {
    boolean validityOfTypes = false;
    
    for (Type type : types) {
      validityOfTypes |= (type.equals(lhs.getType()) && 
          type.equals(rhs.getType()));
    }
    return !validityOfTypes;
  }

  @Override
  public Type getType() {
    return this.binaryOp.getType();
  }

}
