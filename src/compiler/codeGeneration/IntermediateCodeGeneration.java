package compiler.codeGeneration;

import compiler.assignables.ArrayElem;
import compiler.assignables.Call;
import compiler.assignables.First;
import compiler.assignables.Function;
import compiler.assignables.NewPair;
import compiler.assignables.Second;
import compiler.assignables.Variable;
import compiler.expressions.BinaryOperExpr;
import compiler.expressions.UnaryOperExpr;
import compiler.expressions.ValueExpr;
import compiler.literals.ArrayLiter;
import compiler.statements.AssignStat;
import compiler.statements.BeginEndStat;
import compiler.statements.ExitStat;
import compiler.statements.FreeStat;
import compiler.statements.IfThenElseStat;
import compiler.statements.PrintStat;
import compiler.statements.PrintlnStat;
import compiler.statements.ReadStat;
import compiler.statements.ReturnStat;
import compiler.statements.SkipStat;
import compiler.statements.StatList;
import compiler.statements.WhileStat;

public class IntermediateCodeGeneration<T> implements AbstractSyntaxTreeVisitor<T> {

  @Override
  public T visit(Function func) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(ArrayElem arrayElem) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(ArrayLiter arrayLiter) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(Call call) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(First fst) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(NewPair newPair) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(Second snd) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(BinaryOperExpr binExpr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(UnaryOperExpr unExpr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(ValueExpr valueExpr) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(Variable variable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(AssignStat assignStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(BeginEndStat beginEnd) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(ExitStat exitStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(FreeStat freeStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(IfThenElseStat ifStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(ReturnStat returnStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(PrintlnStat printlnStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(PrintStat printStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(ReadStat readStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(SkipStat skipStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(StatList statList) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T visit(WhileStat whileStat) {
    // TODO Auto-generated method stub
    return null;
  }

}
