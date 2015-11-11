package compiler.semanticCheck;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiler.CodePosition;
import compiler.errorHandling.SyntaxException;
import compiler.expressions.Expr;
import compiler.literals.ArrayLiter;
import compiler.literals.BoolLiter;
import compiler.literals.CharLiter;
import compiler.literals.IntLiter;
import compiler.literals.PairLiter;
import compiler.literals.StringLiter;
import compiler.types.ArrType;

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
	int lineNum = ctx.start.getLine();
	int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum);  
	String sign = ctx.start.getText(); //am I getting sign here?
	int value = Integer.parseInt(ctx.getChild(1).getText()); //I need to get 2nd token(number) here
	if(sign == "-"){
		value = value * (-1);
	}
    return new IntLiter(value,p);
  }

  @Override
  public ReturnableType visitCharLiterExpr(CharLiterExprContext ctx) {
	int lineNum = ctx.start.getLine();
	int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum);  //duplication
	String text = ctx.start.getText();
	return new CharLiter(text,p);
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
	int lineNum = ctx.start.getLine();
    int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum); 
	String text = ctx.start.getText();
	return new StringLiter(text,p);
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
	int lineNum = ctx.start.getLine();
	int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum); 
	String value = ctx.start.getText();
	return new BoolLiter(value,p);
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
	int lineNum = ctx.start.getLine();
	int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum); 
	Expr first = (Expr) ctx.getChild(0);
	Expr second = (Expr) ctx.getChild(1);
	return new PairLiter(first,second,p);
  }

  @Override
  public ReturnableType visitFunc(FuncContext ctx) {
    System.out.println("I found a function definition!");
    return null;
  }

  @Override
  public ReturnableType visitIntLiter(IntLiterContext ctx) {
	int lineNum = ctx.start.getLine();
	int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum);
	int value = Integer.parseInt(ctx.start.getText());
    return new IntLiter(value,p);
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
	/*int lineNum = ctx.start.getLine();
	int charNum = ctx.start.getCharPositionInLine();
	CodePosition p = new CodePosition(lineNum, charNum);
	int type = ctx.start.getType();
    return new ArrayLiter();*/
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
