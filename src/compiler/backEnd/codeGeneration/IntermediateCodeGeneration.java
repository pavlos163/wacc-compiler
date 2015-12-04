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

public class IntermediateCodeGeneration<T> implements AbstractSyntaxTreeVisitor<T> {
  
  @Override
  public T accept(ProgramNode programNode) {
    // TODO Auto-generated method stub
    return null;
  }
  
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
