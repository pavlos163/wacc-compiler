package compiler.statements;

import compiler.CodePosition;
import compiler.assignables.AssignLHS;
import compiler.assignables.AssignRHS;
import compiler.assignables.Call;
import compiler.errorHandling.SemanticException;

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
    if (!(rhs instanceof Call || lhs.getType().equals(rhs.getType()))) {
      throw new SemanticException("Types of the assigned and assigner must"
          + " be the same.");
    }
  }

}
