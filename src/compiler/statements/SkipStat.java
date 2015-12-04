package compiler.statements;

import compiler.CodePosition;
import compiler.codeGeneration.AbstractSyntaxTreeVisitor;

public class SkipStat extends Stat {

  public SkipStat(CodePosition codePos) {
    super(codePos);
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
