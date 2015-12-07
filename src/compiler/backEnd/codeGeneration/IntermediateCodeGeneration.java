package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.LinkedList;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.And;
import compiler.backEnd.instructions.AssemblerDirective;
import compiler.backEnd.instructions.Branch;
import compiler.backEnd.instructions.BranchLink;
import compiler.backEnd.instructions.Cmp;
import compiler.backEnd.instructions.Cond;
import compiler.backEnd.instructions.Eor;
import compiler.backEnd.instructions.Label;
import compiler.backEnd.instructions.Ldr;
import compiler.backEnd.instructions.Mov;
import compiler.backEnd.instructions.Mul;
import compiler.backEnd.instructions.Orr;
import compiler.backEnd.instructions.Pop;
import compiler.backEnd.instructions.Push;
import compiler.backEnd.instructions.Str;
import compiler.backEnd.instructions.Sub;
import compiler.backEnd.instructions.Token;
import compiler.backEnd.operands.Address;
import compiler.backEnd.operands.ImmediateValue;
import compiler.backEnd.operands.Register;
import compiler.backEnd.operands.RegisterList;
import compiler.frontEnd.assignables.ArrayElem;
import compiler.frontEnd.assignables.AssignLHS;
import compiler.frontEnd.assignables.AssignRHS;
import compiler.frontEnd.assignables.Call;
import compiler.frontEnd.assignables.First;
import compiler.frontEnd.assignables.Function;
import compiler.frontEnd.assignables.NewPair;
import compiler.frontEnd.assignables.Second;
import compiler.frontEnd.assignables.Variable;
import compiler.frontEnd.expressions.BinaryOperExpr;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.expressions.UnaryOperExpr;
import compiler.frontEnd.expressions.ValueExpr;
import compiler.frontEnd.literals.ArrayLiter;
import compiler.frontEnd.literals.BoolLiter;
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
import compiler.frontEnd.symbolTable.Identifier;
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

public class IntermediateCodeGeneration implements 
    AbstractSyntaxTreeVisitor<Deque<Token>> {
  
  private static final Label DIV_LABEL = new Label("__aeabi_idiv");
  private static final Label MOD_LABEL = new Label("__aeabi_idivmod");
  
  private RegisterList registers = new RegisterList();
  private Register returnedRegister = null;
  private ArmCodeState codeState = new ArmCodeState();
  private int stackOffset;
  private int currOffset;
  private int extraOffset;
  
  int ifStatementCounter = 0;
  
  @Override
  public Deque<Token> visit(ProgramNode programNode) {
    Deque<Token> textSection = new LinkedList<Token>();
    
    StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
    stackOffset = programNode.getStatements().accept(stackVisitor);
    currOffset = stackOffset;
    
    textSection.add(new AssemblerDirective(".text"));
    textSection.add(new AssemblerDirective(".global main"));
    
    try {
      // First we visit the functions and generate the code.
      
      for (Function func : programNode.getFunctions()) {
        textSection.addAll(func.accept(this));
      }
      
      Deque<Token> bodyStatements = 
          programNode.getStatements().accept(this);
            
      // TODO: Handle stack.
            
      textSection.add(new Label("main"));
      textSection.add(new Push(Register.lr));
      
      extraOffset = stackOffset;
      subExtraOffset(textSection);
      
      // Add code for the main label.
      textSection.addAll(bodyStatements);
      
      extraOffset = stackOffset;
      addExtraOffset(textSection);
      
      ImmediateValue value = new ImmediateValue("0");
      value.setPrefix("=");
      
      textSection.add(new Ldr(Register.r0, value));
      textSection.add(new Pop(Register.pc));
      textSection.add(new AssemblerDirective(".ltorg"));
      
      // After main label code.
      textSection.addAll(codeState.getAfterMainLabelCode());
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    Deque<Token> finalCode = codeState.getData();
    finalCode.addAll(textSection);
    return finalCode;
  }

  private void subExtraOffset(Deque<Token> textSection) {
    ImmediateValue val;
    if (extraOffset > 1024) {
      extraOffset -= 1024;
      val = new ImmediateValue(1024);
      textSection.add(new Sub(Register.sp, Register.sp, val));
      subExtraOffset(textSection);
    }
    else if (extraOffset > 0) {
      val = new ImmediateValue(extraOffset);
      textSection.add(new Sub(Register.sp, Register.sp, val));
    }
  }
  
  private void addExtraOffset(Deque<Token> textSection) {
    ImmediateValue val;
    if (extraOffset > 1024) {
      extraOffset -= 1024;
      val = new ImmediateValue(1024);
      textSection.add(new Add(Register.sp, Register.sp, val));
      addExtraOffset(textSection);
    }
    else if (extraOffset > 0) {
      val = new ImmediateValue(extraOffset);
      textSection.add(new Add(Register.sp, Register.sp, val));
    }
  }
  
  @Override
  public Deque<Token> visit(Function func) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(ArrayElem arrayElem) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(ArrayLiter arrayLiter) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(Call call) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(First fst) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(NewPair newPair) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(Second snd) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(BinaryOperExpr binExpr) {    
    Deque<Token> statementList = new LinkedList<Token>();
    
    // First we are visiting the left and right hand side expressions.
    Expr lhs = binExpr.getLHS();
    statementList.addAll(lhs.accept(this));
    Register regLHS = returnedRegister;
    
    // We also assign registers to these expressions.
    Expr rhs = binExpr.getRHS();
    statementList.addAll(rhs.accept(this));
    Register regRHS = returnedRegister;
        
    Register destination = registers.getGeneralRegister();
    
    Register regZero = registers.getReturnRegister();
    Register regOne = registers.getReturnRegister();
    
    ImmediateValue exprTrue = new ImmediateValue("1");
    ImmediateValue exprFalse = new ImmediateValue("0");
    
    switch(binExpr.getBinOp().getString()) {
    case "*":
      statementList.add(new Mul(destination, regLHS, regRHS));
    case "/":
      statementList.add(new Mov(regZero, regLHS));
      statementList.add(new Mov(regOne, regRHS));
      
      statementList.add(new BranchLink(DIV_LABEL));
      statementList.add(new Mov(destination, regZero));
      break;
    case "%":
      statementList.add(new Mov(regZero, regLHS));
      statementList.add(new Mov(regOne, regRHS));
      
      statementList.add(new BranchLink(MOD_LABEL));
      statementList.add(new Mov(destination, regOne));
      break;
    case "+":
      statementList.add(new Add(destination, regLHS, regRHS));
      break;
    case "-":
      statementList.add(new Sub(destination, regLHS, regRHS));
      break;
    case ">":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.GT, destination, exprTrue));
      statementList.add(new Mov(Cond.LE, destination, exprFalse));
      break;
    case ">=":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.GE, destination, exprTrue));
      statementList.add(new Mov(Cond.LT, destination, exprFalse));
      break;
    case "<":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.LT, destination, exprTrue));
      statementList.add(new Mov(Cond.GE, destination, exprFalse));
      break;
    case "<=":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.LE, destination, exprTrue));
      statementList.add(new Mov(Cond.GT, destination, exprFalse));
      break;
    case "==":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.EQ, destination, exprTrue));
      statementList.add(new Mov(Cond.NE, destination, exprFalse));
      break;
    case "!=":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.NE, destination, exprTrue));
      statementList.add(new Mov(Cond.EQ, destination, exprFalse));
      break;
    case "&&":
      statementList.add(new And(destination, regLHS, regRHS));
      break;
    case "||":
      statementList.add(new Orr(destination, regLHS, regRHS));
      break;
    }
    
    registers.freeRegister(regZero);
    registers.freeRegister(regOne);
    registers.freeRegister(destination);
    
    returnedRegister = destination;
    return statementList;
  }

  @Override
  public Deque<Token> visit(UnaryOperExpr unExpr) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    Expr expression = unExpr.getExpr();
    statementList.addAll(expression.accept(this));
    Register regExpr = returnedRegister;
    Register regHelper = registers.getGeneralRegister();
    
    ImmediateValue zeroVal = new ImmediateValue("0");
    ImmediateValue oneVal = new ImmediateValue("1");
    
    switch(unExpr.getOp().getString()) {
    case "!":
      // R4 = R4 && 0 => R4 = !R4
      statementList.add(new Eor(regExpr, regExpr, oneVal));
      break;
    case "-":
      // R5 = 0
      statementList.add(new Mov(regHelper, zeroVal));
      // R4 = R5 - R4 => R4 = -R4
      statementList.add(new Sub(regExpr, regHelper, regExpr));
      break;
    case "ord":
      // ?
    case "len":
      // ?
    case "chr":
      // ?
    }
    
    registers.freeRegister(regExpr);
    
    returnedRegister = regExpr;
    return statementList;
  }

  @Override
  public Deque<Token> visit(ValueExpr valueExpr) {
    Deque<Token> statementList = new LinkedList<Token>();

    if (valueExpr.getType().equals(BaseType.typeInt)) {
      String intValue = valueExpr.getLiter().getString();
      // Find a register to store the value in.
      Register reg = registers.getGeneralRegister();
      ImmediateValue val = new ImmediateValue(intValue);
      val.setPrefix("=");
      
      statementList.add(new Ldr(reg, val));
      returnedRegister = reg;
    }
    else if (valueExpr.getType().equals(BaseType.typeBool)) {
      int boolValue = ((BoolLiter) (valueExpr.getLiter())).getValue();
      Register reg = registers.getGeneralRegister();
      ImmediateValue val = new ImmediateValue(boolValue);
      
      statementList.add(new Mov(reg, val));
      returnedRegister = reg;
    }
    else if (valueExpr.getType().equals(BaseType.typeChar)) {
      String charValue = valueExpr.getString();
      Register reg = registers.getGeneralRegister();
      char c = removeEscapeSlash(charValue);
      
      ImmediateValue val = new ImmediateValue(charValue);
      statementList.add(new Mov(reg, val));
      returnedRegister = reg;
    }
    else if (valueExpr.getType().equals(new ArrType(BaseType.typeChar))) {
      Register reg = registers.getGeneralRegister();
      ImmediateValue val = new ImmediateValue(codeState.updateData(
          valueExpr.getString()));
      val.setPrefix("=");
      statementList.add(new Ldr(reg, val));
      returnedRegister = reg;
    }
    
    registers.freeRegister(returnedRegister);
    return statementList;
  }

  @Override
  public Deque<Token> visit(Variable variable) {
    Deque<Token> statementList = new LinkedList<Token>();
    returnedRegister = registers.getGeneralRegister();
    
    Identifier varName = variable.getScope().lookUpAll(variable.getName());
    
    if (variable.getType().equals(BaseType.typeBool)) {
      statementList.add(new Ldr(returnedRegister, 
          new Address(Register.sp, varName.getStackPosition()), true));
    }
    else {
      statementList.add(new Ldr(returnedRegister, 
          new Address(Register.sp, varName.getStackPosition())));
    }
    
    return statementList;
  }

  @Override
  public Deque<Token> visit(AssignStat assignStat) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    // For now (if we suppose all LHS to be just variables.
    
    AssignRHS rhs = assignStat.getRhs();
    statementList.addAll(rhs.accept(this));
    
    AssignLHS lhs = assignStat.getLhs();

    if (lhs instanceof Variable) {
      Identifier name = ((Variable) lhs).getScope().lookUpAll(lhs.getName());
      if (name.getStackPosition() == -1) {
        currOffset -= getSize(lhs);
        name.setStackPosition(currOffset);
      }
    }
    else if (lhs instanceof First) {
      
    }
    else if (lhs instanceof Second) {
      
    }
    else if (lhs instanceof ArrayElem) {
      
    }
    Register regRHS = registers.getGeneralRegister();

    Address assignAddress = new Address(Register.sp, currOffset);
    
    if (isByte((Variable) lhs)) {
      statementList.add(new Str(regRHS, assignAddress, true));
    }
    else {
      statementList.add(new Str(regRHS, assignAddress));
    }
    
    registers.freeRegister(regRHS);
    
    return statementList;
  }
  
  private int getSize(AssignLHS lhs) {
    if (lhs.getType().equals(BaseType.typeBool) ||
        lhs.getType().equals(BaseType.typeChar)) {
      return 1;
    }
    return 4;
  }
  
  private boolean isByte(Variable var) {
    return var.getType().equals(BaseType.typeBool) || 
        var.getType().equals(BaseType.typeChar);
  }

  @Override
  public Deque<Token> visit(BeginEndStat beginEnd) {
    return null;
  }

  @Override
  public Deque<Token> visit(ExitStat exitStat) {
    Deque<Token> statementList = new LinkedList<Token>();

    Expr expression = exitStat.getExpr();

    statementList.addAll(expression.accept(this));

    statementList.add(new Mov(registers.getReturnRegister(), 
        returnedRegister));
    
    registers.freeRegister(returnedRegister);
    statementList.add(new BranchLink(new Label("exit")));
    
    return statementList;
  }

  @Override
  public Deque<Token> visit(FreeStat freeStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(IfThenElseStat ifStat) {
  	Deque<Token> statementList = new LinkedList<Token>();
		Expr condition = ifStat.getCondition();
		
		statementList.addAll(condition.accept(this));
		
		Register reg = registers.getGeneralRegister();
		
		statementList.add(new Cmp(reg, new ImmediateValue("0")));
		statementList.add(new Branch(Cond.EQ, new Label("L" +
		    (ifStatementCounter * 2))));
    
		registers.freeRegister(reg);
    statementList.addAll(ifStat.getIf().accept(this));
    
    statementList.add(new Branch(new Label("L" + (ifStatementCounter * 2 + 1))));
    statementList.add(new Label("L" + (ifStatementCounter * 2)));
		
    statementList.addAll(ifStat.getElse().accept(this));
		
		statementList.add(new Label("L" + (ifStatementCounter * 2 + 1)));
		
	  ifStatementCounter++;
  	return statementList;
  }

  @Override
  public Deque<Token> visit(ReturnStat returnStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(PrintlnStat printlnStat) {
    return  visitPrint(printlnStat.getExpr().accept(this), 
        returnedRegister, printlnStat.getExpr().getType(), true);
  }

  @Override
  public Deque<Token> visit(PrintStat printStat) {
    return visitPrint(printStat.getExpr().accept(this), 
        returnedRegister, printStat.getExpr().getType(), false);
  }
  
  private Deque<Token> visitPrint(Deque<Token> tokens, 
      Register register, Type type, Boolean isLn) {
    
    // String.
    if (type.equals(new ArrType(BaseType.typeChar))) {
      tokens.add(new Mov(Register.r0, register));
      tokens.add(new BranchLink(new Label(ArmCodeState.PRINT_STRING)));
      codeState.usePrintString();
    }
    else if (type.equals(BaseType.typeBool)) {
      tokens.add(new Mov(Register.r0, register));
      tokens.add(new BranchLink( new Label(ArmCodeState.PRINT_BOOL)));
      codeState.usePrintBool();
    }
    else if (type.equals(BaseType.typeInt)) {
      tokens.add(new Mov(Register.r0, register));
      tokens.add(new BranchLink( new Label(ArmCodeState.PRINT_INT)));
      codeState.usePrintInt();
    }
    else if (type.equals(BaseType.typeChar)) {
      tokens.add(new Mov(Register.r0, register));
      tokens.add(new BranchLink(new Label(ArmCodeState.PRINT_CHAR)));
    }
    
    if (isLn) {
      tokens.add(new BranchLink(new Label(ArmCodeState.PRINT_LN)));
      codeState.usePrintln();
    }
    
    registers.freeRegister(register);
    return tokens;
  }

  @Override
  public Deque<Token> visit(ReadStat readStat) {
    Deque<Token> tokens = new LinkedList<Token>();
    AssignLHS readItem = readStat.getItem();
    readItem.accept(this);
    
    if (readItem.getType().equals(BaseType.typeInt)) {
      if (readItem instanceof Variable) {
        Variable var = (Variable) readItem;
        Identifier ident = var.getScope().lookUpAll(var.getName());
        tokens.add(new Add(returnedRegister, Register.sp,
            new ImmediateValue(ident.getStackPosition())));
      }
      tokens.add(new Mov(Register.r0, returnedRegister));
      tokens.add(new BranchLink( new Label(codeState.READ_INT)));
      codeState.useReadInt();
    }
    else if (readItem.getType().equals(BaseType.typeChar)) {
      if (readItem instanceof Variable) {
        Variable var = (Variable) readItem;
        Identifier ident = var.getScope().lookUpAll(var.getName());
        tokens.add(new Add(returnedRegister, Register.sp,
            new ImmediateValue(ident.getStackPosition())));
      }
      tokens.add(new Mov(Register.r0, returnedRegister));
      tokens.add(new BranchLink(new Label(codeState.READ_CHAR)));
      codeState.useReadChar();
    }
    
    registers.freeRegister(returnedRegister);
    return tokens;
  }

  @Override
  public Deque<Token> visit(SkipStat skipStat) {
    return new LinkedList<Token>();
  }

  @Override
  public Deque<Token> visit(StatList statList) {
    Deque<Token> tokens = new LinkedList<Token>();
    
    for (ASTNode stat: statList.getChildren()) {
      tokens.addAll(stat.accept(this));
    }
    
    return tokens;
  }

  @Override
  public Deque<Token> visit(WhileStat whileStat) {
    // TODO Auto-generated method stub
    return null;
  }
  
  private char removeEscapeSlash(String charValue) {
    charValue.replace("\\0", "\0");
    charValue.replace("\\b", "\b");
    charValue.replace("\\n", "\n");
    charValue.replace("\\f", "\f");
    charValue.replace("\\r", "\r");
    charValue.replace("\\\"", "\"");
    charValue.replace("\\'", "'");
    charValue.replace("\\\\", "\\");
    return charValue.charAt(1);
  }

}
