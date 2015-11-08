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

public class SemanticCheckVisitor implements WaccParserVisitor<Void> {

  @Override
  public Void visit(@NotNull ParseTree arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitChildren(@NotNull RuleNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitErrorNode(@NotNull ErrorNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitTerminal(@NotNull TerminalNode arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitIntSign(IntSignContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitCharLiterExpr(CharLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitArgList(ArgListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitIdentExpr(IdentExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitArrayType(ArrayTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitParam(ParamContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitParamList(ParamListContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitStringLiterExpr(StringLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitAssignRHS(AssignRHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitType(TypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitBoolLiter(BoolLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitBaseType(BaseTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitBinaryOperExpr(BinaryOperExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitBoolLiterExpr(BoolLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitPairLiter(PairLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitFunc(FuncContext ctx) {
    System.out.println("I found a function definition!");
    return null;
  }

  @Override
  public Void visitIntLiter(IntLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitPairElemType(PairElemTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitArrayElemExpr(ArrayElemExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitIntLiterExpr(IntLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitParanthesesExpr(ParanthesesExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitPairElem(PairElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitArrayElem(ArrayElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitBinaryOper(BinaryOperContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitStat(StatContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitAssignLHS(AssignLHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitUnaryOper(UnaryOperContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitProgram(ProgramContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitPairType(PairTypeContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitArrayLiter(ArrayLiterContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitUnaryOperExpr(UnaryOperExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Void visitPairLiterExpr(PairLiterExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
