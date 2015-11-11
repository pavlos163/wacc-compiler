package compiler.semanticCheck;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.WaccParser.ArgListContext;
import antlr.WaccParser.ArrayElemContext;
import antlr.WaccParser.ArrayElemExprContext;
import antlr.WaccParser.ArrayLiterContext;
import antlr.WaccParser.ArrayTypeContext;
import antlr.WaccParser.AssignLHSContext;
import antlr.WaccParser.AssignRHSContext;
import antlr.WaccParser.AssignStatContext;
import antlr.WaccParser.BaseTypeContext;
import antlr.WaccParser.BeginStatContext;
import antlr.WaccParser.BinaryOperContext;
import antlr.WaccParser.BinaryOperExprContext;
import antlr.WaccParser.BoolLiterContext;
import antlr.WaccParser.BoolLiterExprContext;
import antlr.WaccParser.CharLiterExprContext;
import antlr.WaccParser.ExitStatContext;
import antlr.WaccParser.FreeStatContext;
import antlr.WaccParser.FuncContext;
import antlr.WaccParser.IdentExprContext;
import antlr.WaccParser.IfThenElseStatContext;
import antlr.WaccParser.IfThenStatContext;
import antlr.WaccParser.IntLiterContext;
import antlr.WaccParser.IntLiterExprContext;
import antlr.WaccParser.IntSignContext;
import antlr.WaccParser.PairElemContext;
import antlr.WaccParser.PairElemTypeContext;
import antlr.WaccParser.PairLiterContext;
import antlr.WaccParser.PairLiterExprContext;
import antlr.WaccParser.PairTypeContext;
import antlr.WaccParser.ParamContext;
import antlr.WaccParser.ParamListContext;
import antlr.WaccParser.ParanthesesExprContext;
import antlr.WaccParser.PrintStatContext;
import antlr.WaccParser.PrintlnStatContext;
import antlr.WaccParser.ProgramContext;
import antlr.WaccParser.ReadStatContext;
import antlr.WaccParser.ReturnStatContext;
import antlr.WaccParser.SkipStatContext;
import antlr.WaccParser.StatContext;
import antlr.WaccParser.StatListContext;
import antlr.WaccParser.StringLiterExprContext;
import antlr.WaccParser.TypeContext;
import antlr.WaccParser.UnaryOperContext;
import antlr.WaccParser.UnaryOperExprContext;
import antlr.WaccParser.WhileStatContext;
import antlr.WaccParserVisitor;

public class SemanticCheckVisitor implements WaccParserVisitor<ReturnableType> {

  @Override
  public ReturnableType visit(@NotNull ParseTree arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitChildren(@NotNull RuleNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitErrorNode(@NotNull ErrorNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitTerminal(@NotNull TerminalNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitIntSign(IntSignContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitCharLiterExpr(CharLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitArgList(ArgListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitIdentExpr(IdentExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitArrayType(ArrayTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitParam(ParamContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitParamList(ParamListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitStringLiterExpr(StringLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitAssignRHS(AssignRHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitType(TypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitBoolLiter(BoolLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitBaseType(BaseTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitBinaryOperExpr(BinaryOperExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitBoolLiterExpr(BoolLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitPairLiter(PairLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitFunc(FuncContext ctx) {
    System.out.println("I found a function definition!");
    return null;
  }

  @Override
  public ReturnableType visitIntLiter(IntLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitPairElemType(PairElemTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitArrayElemExpr(ArrayElemExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitIntLiterExpr(IntLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitParanthesesExpr(ParanthesesExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitPairElem(PairElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitArrayElem(ArrayElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitBinaryOper(BinaryOperContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  
  private ReturnableType visitStat(StatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitAssignLHS(AssignLHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitUnaryOper(UnaryOperContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitProgram(ProgramContext ctx) {
    // TODO Auto-generated method stub
    System.out.println("Who's awake?");
    return null;
  }

  @Override
  public ReturnableType visitPairType(PairTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitArrayLiter(ArrayLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitUnaryOperExpr(UnaryOperExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitPairLiterExpr(PairLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitIfThenElseStat(IfThenElseStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitIfThenStat(IfThenStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitStatList(StatListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitBeginStat(BeginStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitReadStat(ReadStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitReturnStat(ReturnStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitAssignStat(AssignStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitWhileStat(WhileStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitPrintStat(PrintStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitFreeStat(FreeStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitExitStat(ExitStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitSkipStat(SkipStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ReturnableType visitPrintlnStat(PrintlnStatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
