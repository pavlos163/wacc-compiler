package compiler.frontEnd.statements;

import java.util.LinkedList;
import java.util.List;

import compiler.CodePosition;

public class StatList extends Stat {
  
  private final List<Stat> statements;

  public StatList(List<Stat> statements, CodePosition codePos) {
    super(codePos);
    if (statements == null) {
      this.statements = new LinkedList<>();
    }
    else {
      this.statements = statements;
    }
  }

  @Override
  public CodePosition getPosition() {
    return codePos;
  }

}
