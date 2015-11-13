package compiler.expressions;

import compiler.CodePosition;
import compiler.errorHandling.SemanticException;
import compiler.errorHandling.SyntaxException;
import compiler.literals.UnaryOperLiter;
import compiler.types.ArrType;
import compiler.types.BaseType;
import compiler.types.Type;

public class UnaryOperExpr implements Expr {
  
  private final UnaryOperLiter unaryOp;
  private final CodePosition codePos;
  private final Expr expr;
  
  public UnaryOperExpr(UnaryOperLiter unaryOp, Expr expr, CodePosition codePos) 
      throws SemanticException, SyntaxException {
    this.unaryOp = unaryOp;
    this.codePos = codePos;
    this.expr = expr;
    
    if (!typeMatch()) {
      throw new SemanticException("Type MissMatch error at " + codePos.toString());
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

  @Override
  public Type getType() {
    return this.unaryOp.getType();
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
