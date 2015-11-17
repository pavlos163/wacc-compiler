package compiler.statements;

import compiler.CodePosition;
import compiler.assignables.AssignLHS;
import compiler.assignables.AssignRHS;
import compiler.assignables.Call;
import compiler.errorHandling.SemanticException;
import compiler.types.ArrType;
import compiler.types.BaseType;

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
    if (rhs.getType() == null || lhs.getType() == null) {
      return;
    }
    if (!rhs.getType().equals(lhs.getType())) {
      throw new SemanticException("At: " + codePos.toString() + 
          " types of the LHS and RHS values must be the same."
          + " Actual types: (" + lhs.getType() + ", " + 
          rhs.getType() + ")");
    }
  }
}
