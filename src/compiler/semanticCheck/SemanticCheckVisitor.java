package compiler.semanticCheck;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiler.CodePosition;
import compiler.assignables.ArgList;
import compiler.assignables.AssignLHS;
import compiler.errorHandling.SyntaxException;
import compiler.expressions.BinaryOperExpr;
import compiler.expressions.Expr;
import compiler.expressions.UnaryOperExpr;
import compiler.expressions.ValueExpr;
import compiler.literals.ArrayLiter;
import compiler.literals.BinaryOperLiter;
import compiler.literals.BoolLiter;
import compiler.literals.CharLiter;
import compiler.literals.IntLiter;
import compiler.literals.Liter;
import compiler.literals.PairLiter;
import compiler.literals.StringLiter;
import compiler.literals.UnaryOperLiter;
import compiler.statements.AssignStat;
import compiler.statements.BeginEndStat;
import compiler.statements.ExitStat;
import compiler.statements.FreeStat;
import compiler.statements.IfThenElseStat;
import compiler.statements.IfThenStat;
import compiler.statements.PrintStat;
import compiler.statements.PrintlnStat;
import compiler.statements.ReadStat;
import compiler.statements.ReturnStat;
import compiler.statements.SkipStat;
import compiler.statements.Stat;
import compiler.statements.StatList;
import compiler.statements.WhileStat;
import compiler.types.ArrType;
import compiler.types.BaseType;
import compiler.types.PairType;
import compiler.types.Type;
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
import antlr.WaccParser.ExprContext;
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
  public IntLiter visitIntSign(IntSignContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    
    if (ctx.PLUS() != null) {
      return new IntLiter(-1, codePos);
    }
    return new IntLiter(1, codePos);
  }

  @Override
  public ValueExpr visitCharLiterExpr(CharLiterExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    String text = ctx.CHAR_LITER().getText();
    
    CharLiter charLtr = new CharLiter(text, codePos);
    return new ValueExpr(charLtr, codePos);
  }

  @Override
  public ArgList visitArgList(ArgListContext ctx) {
    List<Expr> expressions = new LinkedList<>();
    CodePosition codePos = initialisePosition(ctx);
    
    if (ctx != null) {
      for (ExprContext ectx : ctx.expr()) {
        expressions.add(visitExpr(ectx));
      }
    }
    
    return new ArgList(expressions, codePos);
  }

  @Override
  public ReturnableType visitIdentExpr(IdentExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrType visitArrayType(ArrayTypeContext ctx) {
    if (ctx.baseType() != null) {
      return new ArrType(visitBaseType(ctx.baseType()));
    }
    else if (ctx.arrayType() != null) {
      return new ArrType(visitArrayType(ctx.arrayType()));
    }
    else if (ctx.pairType() != null) {
      return new ArrType(visitPairType(ctx.pairType()));
    }
    else throw new SyntaxException("Error by the compiler!");
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
  public ValueExpr visitStringLiterExpr(StringLiterExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    String text = ctx.STRING_LITER().getText();
    
    StringLiter stringLtr = new StringLiter(text, codePos);
    return new ValueExpr(stringLtr, codePos);
  }

  @Override
  public ReturnableType visitAssignRHS(AssignRHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Type visitType(TypeContext ctx) {
    if (ctx.baseType() != null) {
      return visitBaseType(ctx.baseType());
    }
    else if (ctx.arrayType() != null) {
      return visitArrayType(ctx.arrayType());
    }
    else if (ctx.pairType() != null) {
      return visitPairType(ctx.pairType());
    }
    else throw new SyntaxException("Error by the compiler!");
  }

  @Override
  public BoolLiter visitBoolLiter(BoolLiterContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    if (ctx.TRUE() != null) {
      return new BoolLiter("true", codePos);
    }
    return new BoolLiter("false", codePos);
  }

  @Override
  public Type visitBaseType(BaseTypeContext ctx) {
    if (ctx.INT() != null) {
      return BaseType.typeInt;
    }
    else if (ctx.CHAR() != null) {
      return BaseType.typeChar;
    }
    else if (ctx.BOOL() != null) {
      return BaseType.typeBool;
    }
    else if (ctx.STRING() != null) {
      return new ArrType(BaseType.typeChar);
    }
    return null;
  }

  @Override
  public BinaryOperExpr visitBinaryOperExpr(BinaryOperExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    BinaryOperLiter binOpLtr = visitBinaryOper(ctx.binaryOper());
    
    Expr exprLeft = visitExpr(ctx.expr(0));
    Expr exprRight = visitExpr(ctx.expr(1));
    
    return new BinaryOperExpr(binOpLtr, exprLeft, exprRight, codePos);
  }

  @Override
  public ValueExpr visitBoolLiterExpr(BoolLiterExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    BoolLiter boolLtr = visitBoolLiter(ctx.boolLiter());
    
    return new ValueExpr(boolLtr, codePos);
  }

  @Override
  public PairLiter visitPairLiter(PairLiterContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    Expr first = (Expr) ctx.getChild(0);
    Expr second = (Expr) ctx.getChild(1);
    
    return new PairLiter(first, second, codePos);
  }

  @Override
  public ReturnableType visitFunc(FuncContext ctx) {
    System.out.println("I found a function definition!");
    return null;
  }

  @Override
  public IntLiter visitIntLiter(IntLiterContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    
    IntLiter sign = visitIntSign(ctx.intSign());
    
    long value = Long.parseLong(ctx.INTEGER().getText());
    return new IntLiter(value * sign.getValue(), codePos);
  }

  @Override
  public Type visitPairElemType(PairElemTypeContext ctx) {
    if (ctx.pairType() != null) {
      return visitPairType(ctx.pairType());
    }
    else if (ctx.baseType() != null) {
      return visitBaseType(ctx.baseType());
    }
    else if (ctx.arrayType() != null) {
      return visitArrayType(ctx.arrayType());
    }
    else throw new SyntaxException("Error by the compiler!");
  }

  @Override
  public ValueExpr visitArrayElemExpr(ArrayElemExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    ArrayLiter arrayElem = visitArrayElem(ctx.arrayElem());
    
    return new ValueExpr(arrayElem, codePos);
  }

  @Override
  public ValueExpr visitIntLiterExpr(IntLiterExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    IntLiter intLtr = visitIntLiter(ctx.intLiter());
    
    return new ValueExpr(intLtr, codePos);
  }

  @Override
  public ReturnableType visitParanthesesExpr(ParanthesesExprContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public PairLiter visitPairElem(PairElemContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    if (ctx.FIRST() != null) {
      // return new First(...)
    }
    // return new Second(...)
    return null;
  }

  @Override
  public ArrayLiter visitArrayElem(ArrayElemContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BinaryOperLiter visitBinaryOper(BinaryOperContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    String value = ctx.getText();
    
    return new BinaryOperLiter(value, codePos);
  }
  
  private Stat visitStat(StatContext ctx) {
    if (ctx != null) {
      return (Stat) ctx.accept(this);
    }
    return null;
  }

  @Override
  public AssignLHS visitAssignLHS(AssignLHSContext ctx) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UnaryOperLiter visitUnaryOper(UnaryOperContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    String value = ctx.getText();
    
    return new UnaryOperLiter(value, codePos);
  }

  @Override
  public ReturnableType visitProgram(ProgramContext ctx) {
    // TODO Auto-generated method stub
    System.out.println("Who's awake?");
    return null;
  }

  @Override
  public PairType visitPairType(PairTypeContext ctx) {
    if (ctx.PAIR() != null) {
      Type fst = (Type) visitPairElemType(ctx.pairElemType(0));
      Type snd = (Type) visitPairElemType(ctx.pairElemType(1));
      return new PairType(fst, snd);
    }
    throw new SyntaxException("The pair must start with the \'pair\' keyword");
  }

  @Override
  public ArrayLiter visitArrayLiter(ArrayLiterContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    List<Expr> expressions = new LinkedList<>();
    
    for (ExprContext ectx : ctx.argList().expr()) {
      expressions.add(visitExpr(ectx));
    }
    
    return new ArrayLiter(expressions, codePos);
  }

  @Override
  public UnaryOperExpr visitUnaryOperExpr(UnaryOperExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    UnaryOperLiter unOpLtr = visitUnaryOper(ctx.unaryOper());
    Expr expression = visitExpr(ctx.expr());
    
    return new UnaryOperExpr(unOpLtr, expression, codePos);
  }

  @Override
  public ValueExpr visitPairLiterExpr(PairLiterExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    PairLiter pairLtr = visitPairLiter(ctx.pairLiter());
    
    return new ValueExpr(pairLtr, codePos);
  }

  @Override
  public IfThenElseStat visitIfThenElseStat(IfThenElseStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    // Symbol table stuff.
    return null;
  }

  @Override
  public IfThenStat visitIfThenStat(IfThenStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    // Symbol table stuff.
    return null;
  }

  @Override
  public StatList visitStatList(StatListContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    List<Stat> statements = new LinkedList<>();
    
    for (StatContext sctx : ctx.stat()) {
      statements.add(visitStat(sctx));
    }
    
    return new StatList(statements, codePos);
  }

  @Override
  public BeginEndStat visitBeginStat(BeginStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    // Initialising scope.
    Stat content = visitStat(ctx.stat());
    // Syntax error if no end.
    
    return new BeginEndStat(content, codePos);
  }

  @Override
  public ReadStat visitReadStat(ReadStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    AssignLHS readItem = visitAssignLHS(ctx.assignLHS());
    
    return new ReadStat(readItem, codePos);
  }

  @Override
  public ReturnStat visitReturnStat(ReturnStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    // Symbol table stuff.
    return null;
  }

  @Override
  public AssignStat visitAssignStat(AssignStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    // Symbol table stuff.
    return null;
  }

  @Override
  public WhileStat visitWhileStat(WhileStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    // Symbol table stuff.
    return null;
  }

  @Override
  public PrintStat visitPrintStat(PrintStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    Expr message = visitExpr(ctx.expr());
    
    return new PrintStat(message, codePos);
  }

  @Override
  public FreeStat visitFreeStat(FreeStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    Expr heapItem = visitExpr(ctx.expr());
    
    return new FreeStat(heapItem, codePos);
  }

  @Override
  public ExitStat visitExitStat(ExitStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    Expr expression = visitExpr(ctx.expr());
    
    return new ExitStat(expression, codePos);
  }

  @Override
  public SkipStat visitSkipStat(SkipStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    
    return new SkipStat(codePos);
  }

  @Override
  public PrintlnStat visitPrintlnStat(PrintlnStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    Expr message = visitExpr(ctx.expr());
    
    return new PrintlnStat(message, codePos);
  }
  
  private Expr visitExpr(ExprContext ctx) {
    if (ctx != null) {
      return (Expr) ctx.accept(this);
    }
    
    return null;
  }
  
  private CodePosition initialisePosition(ParserRuleContext ctx) {
    int lineNum = ctx.start.getLine();
    int charNum = ctx.start.getCharPositionInLine();
    CodePosition codePos = new CodePosition(lineNum, charNum);
    
    return codePos;
  }
  
}
