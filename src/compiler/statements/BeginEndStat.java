package compiler.statements;

import compiler.CodePosition;
import compiler.codeGeneration.AbstractSyntaxTreeVisitor;

public class BeginEndStat extends Stat {
  
  private final Stat content;

  public BeginEndStat(Stat content, CodePosition codePos) {
    super(codePos);
    this.content = content;
  }
  
  public Stat getContent() {
    return content;
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
