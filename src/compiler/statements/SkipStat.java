package compiler.statements;

import compiler.CodePosition;

public class SkipStat extends Stat {

  public SkipStat(CodePosition codePos) {
    super(codePos);
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
