package compiler.frontEnd.expressions;

import compiler.CodePosition;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.errorHandling.SyntaxException;
import compiler.frontEnd.literals.BinaryOperLiter;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

public class BinaryOperExpr implements Expr {
  
  private final BinaryOperLiter binaryOp;
  private final Expr lhs, rhs;
  private final CodePosition codePos;
  
  public BinaryOperExpr(BinaryOperLiter binaryOp,Expr lhs, Expr rhs, 
      CodePosition codePos) throws SemanticException, SyntaxException {
    this.binaryOp = binaryOp;
    this.lhs = lhs;
    this.rhs = rhs;
    this.codePos = codePos;
    checkErrors(lhs, rhs);
  }

  // Check whether the LHS and RHS expressions have the same type.
  // If not, throw a semantic exception.
  private void checkErrors(Expr lhs, Expr rhs) {
    if (typeMissMatch()) {
      throw new SemanticException("At: " + codePos + " expressions "
          + "in the operation must be of the same type.  Actual types: ("
          + lhs.getType() + ", " + rhs.getType() + ")");
    }
  }
  
  // Returns true if the expressions in the operation have correct types.
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
      return !lhs.getType().equals(rhs.getType());
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
    return binaryOp.getType();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
