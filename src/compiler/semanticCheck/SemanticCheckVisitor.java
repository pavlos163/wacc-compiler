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
import compiler.assignables.ArrayElem;
import compiler.assignables.AssignLHS;
import compiler.assignables.AssignRHS;
import compiler.assignables.Call;
import compiler.assignables.First;
import compiler.assignables.Function;
import compiler.assignables.NewPair;
import compiler.assignables.Param;
import compiler.assignables.ParamList;
import compiler.assignables.Second;
import compiler.assignables.Variable;
import compiler.errorHandling.SemanticException;
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
import compiler.statements.PrintStat;
import compiler.statements.PrintlnStat;
import compiler.statements.ReadStat;
import compiler.statements.ReturnStat;
import compiler.statements.SkipStat;
import compiler.statements.Stat;
import compiler.statements.StatList;
import compiler.statements.WhileStat;
import compiler.symbolTable.FunctionIdentifier;
import compiler.symbolTable.Identifier;
import compiler.symbolTable.SymbolTable;
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
  
  // Declare symbol table "tree".
  private SymbolTable<Identifier> scope;
  private SymbolTable<FunctionIdentifier> functions;
  // Remember the function that we are currently looking at.
  private String currFunc;
  private boolean functionHasReturn;
  
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
    if (ctx.MINUS() != null) {
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
    CodePosition codePos = new CodePosition(0,0);
    if (ctx != null)
      codePos = initialisePosition(ctx);
   
    if (ctx != null) {
      for (ExprContext ectx : ctx.expr()) {
        expressions.add(visitExpr(ectx));
      }
    }
    
    return new ArgList(expressions, codePos);
  }

  @Override
  public ReturnableType visitIdentExpr(IdentExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    if (scope.lookUpAll(ctx.IDENT().getText()) != null) {
      return new Variable(ctx.IDENT().getText(), scope, codePos);
    }
    else {
      throw new SemanticException("At " + codePos + 
          " Undeclared variable found " + ctx.IDENT().getText());
    }
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
  public Param visitParam(ParamContext ctx) {
    String ident = ctx.IDENT().getText();
    Type type = visitType(ctx.type());
    CodePosition codePos = initialisePosition(ctx);
    
    return new Param(ident, scope, type, codePos);
  }

  @Override
  public ParamList visitParamList(ParamListContext ctx) {
    List<Param> paramList = new LinkedList<>();
    CodePosition codePos = initialisePosition(ctx);
    
    for (ParamContext param: ctx.param()) {
      paramList.add(visitParam(param));
    }
    
    return new ParamList(paramList, codePos);
  }

  @Override
  public ValueExpr visitStringLiterExpr(StringLiterExprContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    String text = ctx.STRING_LITER().getText();
    
    StringLiter stringLtr = new StringLiter(text, codePos);
    return new ValueExpr(stringLtr, codePos);
  }

  @Override
  public AssignRHS visitAssignRHS(AssignRHSContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    
    // Check all case of RHS assignment.
    if (ctx.pairElem() != null) {
      return visitPairElem(ctx.pairElem());
    }
    else if (ctx.arrayLiter() != null) {
      return visitArrayLiter(ctx.arrayLiter());
    }
    else if (ctx.NEWPAIR() != null) {
      Expr first = visitExpr(ctx.expr(0));
      Expr second = visitExpr(ctx.expr(1));
      return new NewPair(first, second, codePos);
    }
    else if (ctx.CALL() != null) {
      String ident = ctx.IDENT().getText();
      ArgList argList = visitArgList(ctx.argList());
      return new Call(ident, argList, functions,codePos);
    }
    else if (ctx.expr() != null) {
      return visitExpr(ctx.expr(0));
    }
    
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
    
    String value = null;
    
    if (ctx.MUL() != null) {
      value = "*";
    }
    else if (ctx.DIV() != null) {
      value = "/";
    }
    else if (ctx.PLUS() != null) {
      value = "+";
    }
    else if (ctx.MINUS() != null) {
      value = "-";
    }
    else if (ctx.EQUAL() != null) {
      value = "==";
    }
    else if (ctx.NOT_EQUAL() != null) {
      value = "!=";
    }
    else if (ctx.LESS() != null) {
      value = "<";
    }
    else if (ctx.LESS_OR_EQUAL() != null) {
      value = "<=";
    }
    else if (ctx.GREATER() != null) {
      value = ">";
    }
    else if (ctx.GREATER_OR_EQUAL() != null) {
      value = ">=";
    }
    else if (ctx.AND() != null) {
      value = "&&";
    }
    else if (ctx.OR() != null) {
      value = "||";
    }
    else if (ctx.MOD() != null) {
      value = "%";
    }
    
    BinaryOperLiter binOpLtr = new BinaryOperLiter(value, codePos);
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
    return new PairLiter(codePos);
  }

  @Override
  public Function visitFunc(FuncContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    List<Param> parameters = new LinkedList<Param>();
    List<Type> typeOfParameters = new LinkedList<Type>();
    
    // New scope for the parameters.
    scope = scope.newScope();
    
    if (ctx.paramList() != null) {
      parameters = visitParamList(ctx.paramList()).getParameters();
    }
    Type returnType = visitType(ctx.type());
    currFunc = ctx.IDENT().getText();
    functionHasReturn = false;
    
    for (Param param: parameters) {
      typeOfParameters.add(param.getType());
      scope.add(param.getIdent(), 
          new Identifier(param.getType(), codePos));
    }
    if (functions.lookUpAll(currFunc) != null) {
      throw new SemanticException("Function redeclaration at " 
          + codePos.toString());
    }
    functions.add(currFunc,new FunctionIdentifier(returnType, typeOfParameters,
        codePos));
    
    scope = scope.newScope();
    Function function = new Function(returnType, currFunc, parameters,
        visitStat(ctx.stat()), codePos);
    
    if (!functionHasReturn) {
      throw new SyntaxException("Function doesn't have an return statement " + codePos);
    }
    
    currFunc = null; // We finished visiting the function.
    // Return to the global scope.
    scope = scope.getParentScope();
    scope = scope.getParentScope();
    return function;
  }

  @Override
  public IntLiter visitIntLiter(IntLiterContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    
    // Initialize to sign to be positive.
    IntLiter sign = new IntLiter(1, codePos);
    if (ctx.intSign() != null) {
      sign = visitIntSign(ctx.intSign());
    }
    
    long value = Long.parseLong(ctx.INTEGER().getText());
    return new IntLiter(value * sign.getValue(), codePos);
  }

  @Override
  public Type visitPairElemType(PairElemTypeContext ctx) {
    if (ctx.PAIR() != null) {
      return new PairType();
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
    ArrayElem arrayElem = visitArrayElem(ctx.arrayElem());
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
    return visitExpr(ctx.expr());
  }

  public AssignLHS visitPairElem(PairElemContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    
    if (ctx.FIRST() != null) {
      return new First((AssignLHS) visitExpr(ctx.expr()), 
          codePos, scope);
    } else if (ctx.SECOND() != null) {
      return new Second((AssignLHS) visitExpr(ctx.expr()), 
          scope, codePos);  
    }
    return null;
  }

  @Override
  public ArrayElem visitArrayElem(ArrayElemContext ctx) {
    String ident = ctx.IDENT().getText();
    CodePosition codePos = initialisePosition(ctx);
    List<Expr> exprs = new LinkedList<Expr>();
    
    for (ExprContext context : ctx.expr()) {
      exprs.add(visitExpr(context));
    }
    
    return new ArrayElem(ident, exprs, scope, codePos);
  }
  
  private Stat visitStat(StatContext ctx) {
    if (ctx != null) {
      return (Stat) ctx.accept(this);
    }
    return null;
  }

  @Override
  public AssignLHS visitAssignLHS(AssignLHSContext ctx) {
    if (ctx.IDENT() != null) {
      return new Variable(ctx.IDENT().getText(), scope,
          initialisePosition(ctx));
    }
    else if (ctx.arrayElem() != null) {
      return visitArrayElem(ctx.arrayElem());
    }
    else if (ctx.pairElem() != null) {
      return visitPairElem(ctx.pairElem());
    }
    else {
      System.out.print("Error assignLHS doesn't work!");
    }
    return null;
  }

  @Override
  public UnaryOperLiter visitUnaryOper(UnaryOperContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    String value = null;
    if (ctx.NOT() != null) {
      value = "!";
    }
    else if (ctx.MINUS() != null) {
      value = "-";
    }
    else if (ctx.LEN() != null) {
      value = "len";
    }
    else if (ctx.ORD() != null) {
      value = "ord";
    }
    else if (ctx.CHR() != null) {
      value = "chr";
    }
    
    return new UnaryOperLiter(value, codePos);
  }

  @Override
  public ReturnableType visitProgram(ProgramContext ctx) {
    scope = new SymbolTable<Identifier>();
    // All the variables from the function must get to another scope.
    scope = scope.newScope();
    functions = new SymbolTable<FunctionIdentifier>();
    for (FuncContext func: ctx.func()) {
      func.accept(this);
    }
    scope = scope.getParentScope();
    scope = scope.newScope();
    visitStat(ctx.stat());
    scope = scope.getParentScope();
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
    // If the array is empty.
    CodePosition codePos = initialisePosition(ctx);
    List<Expr> expressions = new LinkedList<>();
    
    if (ctx.argList() != null) {
      for (ExprContext ectx : ctx.argList().expr()) {
        expressions.add(visitExpr(ectx));
      }
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
    scope = scope.newScope();
    boolean initialReturn = functionHasReturn;
    Stat ifBody = visitStat(ctx.stat(0));
    boolean ifRet = functionHasReturn;
    scope = scope.getParentScope();
    functionHasReturn = initialReturn;
    scope = scope.newScope();
    Stat elseBody = visitStat(ctx.stat(1));
    boolean elseRet = functionHasReturn;
    if (currFunc != null) {
      if (elseRet && ifRet) {
        functionHasReturn = true;
      }
      else {
        functionHasReturn = initialReturn;
      }
    }
    Expr condition = visitExpr(ctx.expr());
    return new IfThenElseStat(condition, ifBody, elseBody, codePos);
  }

  @Override
  public StatList visitStatList(StatListContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    List<Stat> statements = new LinkedList<Stat>();
    
    for (StatContext sctx : ctx.stat()) {
      statements.add(visitStat(sctx));
    }
    
    return new StatList(statements, codePos);
  }

  @Override
  public BeginEndStat visitBeginStat(BeginStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    scope = scope.newScope();
    
    Stat content = visitStat(ctx.stat());
    
    scope = scope.getParentScope();
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
    Expr expr = visitExpr(ctx.expr());
    functionHasReturn = true;
    if (currFunc == null) {
      throw new SemanticException("Illegal operation at " + codePos);
    }
    if (!expr.getType().equals(functions.lookUpAll(currFunc).getType())) {
      throw new SemanticException("Type mismatch");
    }
    return new ReturnStat(currFunc, expr, codePos);
  }

  @Override
  public AssignStat visitAssignStat(AssignStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    AssignRHS rhs = visitAssignRHS(ctx.assignRHS());
    if (ctx.type() != null && ctx.IDENT() != null) {
      String varName = ctx.IDENT().getText();
      if (scope.lookUpCurrLevelOnly(varName) != null) {
        throw new SemanticException("At: " + codePos + ". Variable "
            + "Redeclaration.");
      }
      scope.add(varName, new Identifier(visitType(ctx.type()), codePos));
      Variable var = new Variable(ctx.IDENT().getText(), scope, codePos);
      return new AssignStat(var, rhs, codePos);
    }
    else { // Assign left
      AssignLHS lhs = visitAssignLHS(ctx.assignLHS());
      if (scope.lookUpAll(lhs.getName()) == null) {
          throw new SemanticException("At: " + codePos + ". Undeclared variable"
              + " error.");
      }
      return new AssignStat(lhs, rhs, codePos);
    }
  }
  
  private boolean isNumeric(String str) {
    boolean isNum = true;
    try {
      Long.parseLong(str);
    } catch (NumberFormatException e) {
      isNum = false;
    }
    return isNum;
  }

  @Override
  public WhileStat visitWhileStat(WhileStatContext ctx) {
    CodePosition codePos = initialisePosition(ctx);
    scope = scope.newScope();
    
    Expr condition = visitExpr(ctx.expr());
    Stat whileBody = visitStat(ctx.stat());
    
    scope = scope.getParentScope();
    return new WhileStat(condition, whileBody, codePos);
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
    functionHasReturn = true;
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
