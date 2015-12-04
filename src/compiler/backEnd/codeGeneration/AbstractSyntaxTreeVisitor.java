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

public interface AbstractSyntaxTreeVisitor<T> {
  T visit(Function func);
  
  // Assignables.
  T visit(ArrayElem arrayElem);
  
  T visit (ArrayLiter arrayLiter);
  
  T visit (Call call);
  
  T visit(First fst);
  
  T visit (NewPair newPair);
  
  T visit(Second snd);
  
  // Expressions.
  T visit(BinaryOperExpr binExpr);
  
  T visit(UnaryOperExpr unExpr);
  
  T visit(ValueExpr valueExpr);
  
  T visit(Variable variable);
  
  // Statements.
  T visit(AssignStat assignStat);
  
  T visit(BeginEndStat beginEnd);
  
  T visit(ExitStat exitStat);
  
  T visit(FreeStat freeStat);
  
  T visit(IfThenElseStat ifStat);
  
  T visit(ReturnStat returnStat);
  
  T visit(PrintlnStat printlnStat);
  
  T visit(PrintStat printStat);
  
  T visit(ReadStat readStat);
  
  T visit(SkipStat skipStat);
  
  T visit(StatList statList);
  
  T visit(WhileStat whileStat);

  T visit(ProgramNode programNode);
  
}















