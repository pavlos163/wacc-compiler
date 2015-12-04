package compiler.codeGeneration;

import compiler.assignables.*;
import compiler.expressions.*;
import compiler.literals.ArrayLiter;
import compiler.statements.*;

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
  
}















