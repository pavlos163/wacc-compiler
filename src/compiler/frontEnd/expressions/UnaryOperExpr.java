package compiler.frontEnd.expressions;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.errorHandling.SyntaxException;
import compiler.frontEnd.literals.UnaryOperLiter;
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

public class UnaryOperExpr implements Expr {
  
  private final UnaryOperLiter unaryOp;
  private final CodePosition codePos;
  private final Expr expr;
  
  public UnaryOperExpr(UnaryOperLiter unaryOp, Expr expr, CodePosition codePos) 
      throws SemanticException, SyntaxException {
    this.unaryOp = unaryOp;
    this.codePos = codePos;
    this.expr = expr;
    
    checkErrors(expr);
  }
  
  private void checkErrors(Expr expr) {
    if (!typeMatch()) {
      throw new SemanticException("At: " + codePos + " type mismatch error. "
          + "Actual: " + expr.getType() + ", Expected: " + getCorrectType());
    }
  }

  private boolean typeMatch() {
    switch (this.unaryOp.getString()) {
    case "!":
      return expr.getType().equals(BaseType.typeBool);
    case "-":
      return expr.getType().equals(BaseType.typeInt);
    case "len":
      return (expr.getType() instanceof ArrType);
    case "ord":
      return expr.getType().equals(BaseType.typeChar);
    case "chr":
      return expr.getType().equals(BaseType.typeInt);
    default:
      return false;
    }
  }
  
  private String getCorrectType() {
    switch (this.unaryOp.getString()) {
    case "!":
      return "bool";
    case "-":
      return "int";
    case "len":
      return "array";
    case "ord":
      return "char";
    case "chr":
      return "int";
    default:
      return null;
    }
  }

  @Override
  public Type getType() {
    return this.unaryOp.getType();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
