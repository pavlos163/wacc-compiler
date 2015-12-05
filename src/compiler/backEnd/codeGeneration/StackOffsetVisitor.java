package compiler.backEnd.codeGeneration;

import compiler.frontEnd.assignables.ArrayElem;
import compiler.frontEnd.assignables.Call;
import compiler.frontEnd.assignables.First;
import compiler.frontEnd.assignables.Function;
import compiler.frontEnd.assignables.NewPair;
import compiler.frontEnd.assignables.Second;
import compiler.frontEnd.assignables.Variable;
import compiler.frontEnd.expressions.BinaryOperExpr;
import compiler.frontEnd.expressions.UnaryOperExpr;
import compiler.frontEnd.expressions.ValueExpr;
import compiler.frontEnd.literals.ArrayLiter;
import compiler.frontEnd.statements.AssignStat;
import compiler.frontEnd.statements.BeginEndStat;
import compiler.frontEnd.statements.ExitStat;
import compiler.frontEnd.statements.FreeStat;
import compiler.frontEnd.statements.IfThenElseStat;
import compiler.frontEnd.statements.PrintStat;
import compiler.frontEnd.statements.PrintlnStat;
import compiler.frontEnd.statements.ReadStat;
import compiler.frontEnd.statements.ReturnStat;
import compiler.frontEnd.statements.SkipStat;
import compiler.frontEnd.statements.StatList;
import compiler.frontEnd.statements.WhileStat;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.PairType;
import compiler.frontEnd.types.Type;

public class StackOffsetVisitor implements AbstractSyntaxTreeVisitor<Integer> {
  
  private static final Integer CHAR_SIZE = 1;
  private static final Integer BOOL_SIZE = 1;
  private static final Integer INT_SIZE = 4;
  private static final Integer PAIR_SIZE = 4;
  private static final Integer ARRAY_SIZE = 4;
  
  private int stackOffset = 0;
  
  @Override
  public Integer visit(ProgramNode programNode) {
    return stackOffset;
  }

  @Override
  public Integer visit(Function func) {
    return stackOffset;
  }

  @Override
  public Integer visit(ArrayElem arrayElem) {
    return stackOffset;
  }

  @Override
  public Integer visit(ArrayLiter arrayLiter) {
    return stackOffset;
  }

  @Override
  public Integer visit(Call call) {
    return stackOffset;
  }

  @Override
  public Integer visit(First fst) {
    return stackOffset;
  }

  @Override
  public Integer visit(NewPair newPair) {
    return stackOffset;
  }

  @Override
  public Integer visit(Second snd) {
    return stackOffset;
  }

  @Override
  public Integer visit(BinaryOperExpr binExpr) {
    return stackOffset;
  }

  @Override
  public Integer visit(UnaryOperExpr unExpr) {
    return stackOffset;
  }

  @Override
  public Integer visit(ValueExpr valueExpr) {
    return stackOffset;
  }

  @Override
  public Integer visit(Variable variable) {
    return 0;
  }

  @Override
  public Integer visit(AssignStat assignStat) {
    Type type = assignStat.getLhs().getType();
    if (type.equals(BaseType.typeInt)) {
      return INT_SIZE;
    }
    else if (type.equals(BaseType.typeChar)) {
      return CHAR_SIZE;
    }
    else if (type.equals(BaseType.typeBool)) {
      return BOOL_SIZE;
    }
    else if (type.equals(new PairType())) {
      return PAIR_SIZE;
    }
    return ARRAY_SIZE;
  }

  @Override
  public Integer visit(BeginEndStat beginEnd) {
    return 0;
  }

  @Override
  public Integer visit(ExitStat exitStat) {
    return 0;
  }

  @Override
  public Integer visit(FreeStat freeStat) {
    return 0;
  }

  @Override
  public Integer visit(IfThenElseStat ifStat) {
    return 0;
  }

  @Override
  public Integer visit(ReturnStat returnStat) {
    return 0;
  }

  @Override
  public Integer visit(PrintlnStat printlnStat) {
    return 0;
  }

  @Override
  public Integer visit(PrintStat printStat) {
    return 0;
  }

  @Override
  public Integer visit(ReadStat readStat) {
    return 0;
  }

  @Override
  public Integer visit(SkipStat skipStat) {
    return 0;
  }

  @Override
  public Integer visit(StatList statList) {
    for (ASTNode node : statList.getChildren()) {
      stackOffset += node.accept(this);
    }
    return stackOffset;
  }

  @Override
  public Integer visit(WhileStat whileStat) {
    return 0;
  }
  
}
