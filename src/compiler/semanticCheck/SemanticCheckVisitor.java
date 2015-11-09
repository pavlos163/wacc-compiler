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
import antlr.WaccParser.BaseTypeContext;
import antlr.WaccParser.BinaryOperContext;
import antlr.WaccParser.BinaryOperExprContext;
import antlr.WaccParser.BoolLiterContext;
import antlr.WaccParser.BoolLiterExprContext;
import antlr.WaccParser.CharLiterExprContext;
import antlr.WaccParser.FuncContext;
import antlr.WaccParser.IdentExprContext;
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
import antlr.WaccParser.ProgramContext;
import antlr.WaccParser.StatContext;
import antlr.WaccParser.StringLiterExprContext;
import antlr.WaccParser.TypeContext;
import antlr.WaccParser.UnaryOperContext;
import antlr.WaccParser.UnaryOperExprContext;
import antlr.WaccParserVisitor;

public class SemanticCheckVisitor implements WaccParserVisitor<Type> {

  @Override
  public Type visit(@NotNull ParseTree arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitChildren(@NotNull RuleNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitErrorNode(@NotNull ErrorNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitTerminal(@NotNull TerminalNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitIntSign(IntSignContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitCharLiterExpr(CharLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitArgList(ArgListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitIdentExpr(IdentExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitArrayType(ArrayTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitParam(ParamContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitParamList(ParamListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitStringLiterExpr(StringLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitAssignRHS(AssignRHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitType(TypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitBoolLiter(BoolLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitBaseType(BaseTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitBinaryOperExpr(BinaryOperExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitBoolLiterExpr(BoolLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitPairLiter(PairLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitFunc(FuncContext ctx) {
    System.out.println("I found a function definition!");
    return null;
  }

  @Override
  public Type visitIntLiter(IntLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitPairElemType(PairElemTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitArrayElemExpr(ArrayElemExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitIntLiterExpr(IntLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitParanthesesExpr(ParanthesesExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitPairElem(PairElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitArrayElem(ArrayElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitBinaryOper(BinaryOperContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitStat(StatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitAssignLHS(AssignLHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitUnaryOper(UnaryOperContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitProgram(ProgramContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitPairType(PairTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitArrayLiter(ArrayLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitUnaryOperExpr(UnaryOperExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitPairLiterExpr(PairLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
