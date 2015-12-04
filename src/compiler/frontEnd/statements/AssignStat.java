package compiler.frontEnd.statements;

import compiler.CodePosition;
import compiler.backEnd.codeGeneration.AbstractSyntaxTreeVisitor;
import compiler.frontEnd.assignables.AssignLHS;
import compiler.frontEnd.assignables.AssignRHS;
import compiler.frontEnd.errorHandling.SemanticException;

public class AssignStat extends Stat {
  
  private final AssignLHS lhs;
  private final AssignRHS rhs;

  public AssignStat(AssignLHS lhs, AssignRHS rhs, CodePosition codePos) {
    super(codePos);
    this.lhs = lhs;
    this.rhs = rhs;
    checkErrors(lhs, rhs);
  }
  
  public AssignLHS getLhs() {
    return lhs;
  }
  
  public AssignRHS getRhs() {
    return rhs;
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }
  
  private void checkErrors(AssignLHS lhs, AssignRHS rhs) {
    if (!rhs.getType().equals(lhs.getType())) {
      throw new SemanticException("At: " + codePos.toString() + 
          " types of the LHS and RHS values must be the same."
          + " Actual types: (" + lhs.getType() + ", " + 
          rhs.getType() + ")");
    }
  }

  @Override
  public <T> T accept(AbstractSyntaxTreeVisitor<T> visitor) {
    return visitor.visit(this);
  }
}
