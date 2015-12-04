package compiler.frontEnd.literals;

import java.util.List;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.assignables.AssignRHS;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.Type;

public class ArrayLiter implements Liter, AssignRHS {
  
  private final List<Expr> expressions;
  private final ArrType arrayType;
  private final CodePosition codePos;
  
  public ArrayLiter(List<Expr> expressions, CodePosition codePos) {
    this.expressions = expressions;
    this.codePos = codePos;
    this.arrayType = defineArrayType(expressions);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

  @Override
  public Type getType() {
    return arrayType;
  }
  
  public List<Expr> getExpressions() {
    return expressions;
  }

  @Override
  public String getString() {
    return null;
  }
  
  private ArrType defineArrayType(List<Expr> expressions) {
    if (expressions.size() == 0) {
      return new ArrType(null);
    }
    else {
      Type type = (Type) expressions.get(0).getType();
      
      for (Expr expr : expressions) {
        if (expr.getType() != type) {
          return new ArrType(null);
        }
      }
      return new ArrType(type);
    }
  }

  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }

}
