package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
import compiler.backEnd.operands.Operand;
import compiler.backEnd.operands.Register;
import compiler.backEnd.operands.RegisterList;
import compiler.frontEnd.assignables.ArgList;
import compiler.frontEnd.assignables.ArrayElem;
import compiler.frontEnd.assignables.AssignLHS;
import compiler.frontEnd.assignables.AssignRHS;
import compiler.frontEnd.assignables.Call;
import compiler.frontEnd.assignables.First;
import compiler.frontEnd.assignables.Function;
import compiler.frontEnd.assignables.NewPair;
import compiler.frontEnd.assignables.Param;
import compiler.frontEnd.assignables.Second;
import compiler.frontEnd.assignables.Variable;
import compiler.frontEnd.expressions.BinaryOperExpr;
import compiler.frontEnd.expressions.Expr;
import compiler.frontEnd.expressions.UnaryOperExpr;
import compiler.frontEnd.expressions.ValueExpr;
import compiler.frontEnd.literals.ArrayLiter;
import compiler.frontEnd.literals.BoolLiter;
import compiler.frontEnd.literals.PairLiter;
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
  private int currStackSize;
  // Stack for the values there is no space for them 
  // in the registers.
  private Stack<Operand> stack = new Stack<Operand>();
  
  int labelCounter = 0;
  int msgNum = 0;
  
  @Override
  public Deque<Token> visit(ProgramNode programNode) {
    Deque<Token> textSection = new LinkedList<Token>();
    
    StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
    stackOffset = programNode.getStatements().accept(stackVisitor);
    currStackSize = stackOffset;
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
    finalCode.add(new Label(""));
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
    Deque<Token> statementList = new LinkedList<Token>();
    StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
    int funcOffset = func.accept(stackVisitor);
    stackOffset += funcOffset;
    currOffset = stackOffset;
    
    String nameLabel = "f_" + func.getIdent();
    statementList.add(new Label(nameLabel));
    statementList.add(new Push(Register.lr));
    statementList.add(new Sub(Register.sp, Register.sp, 
        new ImmediateValue(funcOffset)));
    // Visit parameters first. Do something there.
    visitParameters(func.getParameters());
    statementList.addAll(func.getStatements().accept(this));
    statementList.add(new Add(Register.sp, Register.sp, 
        new ImmediateValue(funcOffset)));
    stackOffset -= funcOffset;
    
    statementList.add(new Pop(Register.pc));
    statementList.add(new AssemblerDirective(".ltorg"));
    return statementList;
  }
  
  public void visitParameters(List<Param> parameters) {
    // We need to calculate the offsets for the parameters.
    
    int paramOffset = 0;
    for (Param param : parameters) {
      if (param.getType().equals(BaseType.typeInt)) {
        paramOffset += 4;
        param.getScope().lookUpAll(param.getIdent()).
            setStackPosition(paramOffset, stackOffset);
      } 
      else if (param.getType().equals(BaseType.typeBool) || 
          param.getType().equals(BaseType.typeChar)) {
        paramOffset ++;
        param.getScope().lookUpAll(param.getIdent())
            .setStackPosition(paramOffset, stackOffset);
      }
      // TODO: Array and strings.
    }
  }

  @Override
  public Deque<Token> visit(ArrayElem arrayElem) {
    Deque<Token> statementList = new LinkedList<Token>();
    int typeSize = ((BaseType) arrayElem.getType()).getSize();
    
    Register arrayReg = registers.getGeneralRegister();
    Register arrayIndexReg = null;
    
    Identifier name = arrayElem.getScope().lookUpAll(arrayElem.getName());
    
    ImmediateValue offsetValue = new ImmediateValue(currOffset);
    statementList.add(new Add(arrayReg, Register.sp, offsetValue));
    
    List<Expr> expressionList = ((ArrayElem) arrayElem).getExpressions();
    Expr expr;
    for (int i = 0; i < expressionList.size(); i++) {
      expr = expressionList.get(i);
      System.out.println(expr);
      statementList.addAll(expr.accept(this));
      arrayIndexReg = returnedRegister;
      
      statementList.add(new Ldr(arrayReg, new Address(arrayReg)));
      statementList.add(new Mov(Register.r0, arrayIndexReg));
      statementList.add(new Mov(Register.r1, arrayReg));

      statementList.add(new BranchLink(new Label(codeState.ARRAY_BOUND)));
      codeState.throwArrayBoundError();
      statementList.add(new Add(arrayReg, arrayReg, 
          new ImmediateValue("4")));

      if (i == expressionList.size() - 1 || !isString(expr.getType())) {
        statementList.add(new Add(arrayReg, arrayReg, arrayIndexReg, 2));
      }
      else {
        statementList.add(new Add(arrayReg, arrayReg, arrayIndexReg));
      }
      
      statementList.add(new Ldr(arrayReg, new Address(arrayReg)));
    }
    registers.freeRegister(arrayReg);
    
    returnedRegister = arrayReg;
    return statementList;
  }

  private boolean isString(Type type) {
    return type.equals(new ArrType(BaseType.typeChar));
  }
  
  @Override
  public Deque<Token> visit(ArrayLiter arrayLiter) {
    Deque<Token> statementList = new LinkedList<Token>();
    System.out.println("HERE!");
        
    int typeSize;
    if (!arrayLiter.getExpressions().isEmpty()) {
       typeSize = ((BaseType) arrayLiter.getBaseType()).getSize();
    }
    else {
      typeSize = 0;
    }
    
    int arraySize = arrayLiter.getExpressions().size();

    int literSize = arraySize * typeSize + 4;

    ImmediateValue literSizeValue = new ImmediateValue(literSize);
    literSizeValue.setPrefix("=");

    Register reg = registers.getGeneralRegister();
    
    statementList.add(new Ldr(Register.r0, literSizeValue));
    statementList.add(new BranchLink(new Label("malloc")));
    statementList.add(new Mov(reg, Register.r0));
        
    List<Expr> expressionList = arrayLiter.getExpressions();
    Address address;
        
    int offset = 4;
    for (Expr expression : expressionList) {
      statementList.addAll(expression.accept(this));

      address = new Address(reg, offset);
      if (typeSize == 4) {
        statementList.add(new Str(returnedRegister, address));
      }
      else {
        statementList.add(new Str(returnedRegister, address, true));
      }
      offset += typeSize;
      registers.freeRegister(returnedRegister);
    }
            
    if (returnedRegister == null) {
      returnedRegister = registers.getGeneralRegister();
    }
    
    ImmediateValue arraySizeValue = new ImmediateValue(arraySize);
    arraySizeValue.setPrefix("=");
    
    statementList.add(new Ldr(returnedRegister, arraySizeValue));
    statementList.add(new Str(returnedRegister, new Address(reg)));
    
    registers.freeRegister(returnedRegister);
    
    returnedRegister = reg;
    return statementList;
  }

  @Override
  public Deque<Token> visit(Call call) {
    Deque<Token> statementList = new LinkedList<Token>();
    if (call.getArguments().numberOfArguments() != 0) {
      statementList.addAll(visitArguments(call.getArguments()));
    }
    statementList.add(new BranchLink(new Label("f_" + call.getName())));
    returnedRegister = registers.getGeneralRegister();
    statementList.add(new Mov(returnedRegister, Register.r0));
    return statementList;
  }
  
  public Deque<Token> visitArguments(ArgList argList) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    int argOffSet = 0;
    for (Expr expr : argList) {
      statementList.addAll(expr.accept(this));
      Register reg = returnedRegister;
      if (expr.getType().equals(BaseType.typeInt)) {
        argOffSet = -4;
      }
      if (expr.getType().equals(BaseType.typeBool) || 
          expr.getType().equals(BaseType.typeChar)) {
        argOffSet = -1;
      }
      statementList.add(new Str(reg, new Address(Register.sp, argOffSet)));
      registers.freeRegister(reg);
    }
    return statementList;
  }

  @Override
  public Deque<Token> visit(First fst) {
    return visitPairItem(true);
  }
  
  @Override
  public Deque<Token> visit(Second snd) {
    return visitPairItem(false);
  }

  private Deque<Token> visitPairItem(boolean isFst) {
    Deque<Token> tokens = new LinkedList<Token>();
    
    int addressSecond = 4;
    
    Register reg = registers.getGeneralRegister();

    tokens.add(new Ldr(reg, new Address(Register.sp, currStackSize - 4)));
    tokens.add(new Mov(Register.r0, reg));
    tokens.add(new BranchLink(new Label("p_check_null_pointer")));
        
    if (isFst) {
      tokens.add(new Ldr(reg, new Address(reg)));
    }
    else {
      tokens.add(new Ldr(reg, new Address(reg, addressSecond)));
    }
    
    returnedRegister = reg;
    return tokens;
  }
  
  @Override
  public Deque<Token> visit(NewPair newPair) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    ImmediateValue heapSize = new ImmediateValue("8");
    heapSize.setPrefix("=");
    statementList.add(new Ldr(Register.r0, heapSize));
    statementList.add(new BranchLink(new Label("malloc")));
    
    Register heapReg = registers.getGeneralRegister();
    
    statementList.add(new Mov(heapReg, Register.r0));
    registers.freeRegister(Register.r0);
    
    Register regExpr = null;
    int expressionNumber = 0;
    
    for (Expr expression : newPair.getExprs()) {
      statementList.addAll(expression.accept(this));
      regExpr = returnedRegister;
      
      ImmediateValue sizeTypeValue;
      
      if (isByte(expression)) {
        sizeTypeValue = new ImmediateValue("1");
      }
      else {
        sizeTypeValue = new ImmediateValue("4");
      }
      
      sizeTypeValue.setPrefix("=");
      
      statementList.add(new Ldr(Register.r0, sizeTypeValue));
      statementList.add(new BranchLink(new Label("malloc")));
      statementList.add(new Str(regExpr, new Address(Register.r0), 
          isByte(expression)));

      int heapValue = 4 * expressionNumber;
      statementList.add(new Str(Register.r0, new Address(heapReg, heapValue)));
      registers.freeRegister(regExpr);
      expressionNumber++;
    }
    
    returnedRegister = heapReg;
    return statementList;
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
    
    if (stack.size() > 0) {
      statementList.add(new Pop(Register.r11));
      stack.pop();
      regLHS = Register.r11;
      regRHS = Register.r10;
      registers.freeRegister(Register.r10);
    } else {
      registers.freeRegister(regLHS);
      registers.freeRegister(regRHS);
    }
    
    Register destination = registers.getGeneralRegister();
    
    Register regZero = registers.getReturnRegister();
    Register regOne = registers.getReturnRegister();
    
    ImmediateValue exprTrue = new ImmediateValue("1");
    ImmediateValue exprFalse = new ImmediateValue("0");
    
    switch(binExpr.getBinOp().getString()) {
    case "*":
      Register overflowReg = registers.getGeneralRegister();
      statementList.add(new Mul(true, destination, overflowReg, 
          regLHS, regRHS));
      ImmediateValue asrFlags = new ImmediateValue("ASR #31");
      asrFlags.setPrefix("");
      statementList.add(new Cmp(overflowReg, destination, asrFlags));
      statementList.add(new BranchLink(Cond.NE,
          new Label(codeState.INTEGER_OVERFLOW)));
      codeState.throwOverflow();
      registers.freeRegister(overflowReg);
      break;
    case "/":
      statementList.add(new Mov(regZero, regLHS));
      statementList.add(new Mov(regOne, regRHS));
      statementList.add(new BranchLink(new Label(
          codeState.DIVIDE_BY_ZERO)));
      codeState.checkDivisionByZero();
      statementList.add(new BranchLink(DIV_LABEL));
      statementList.add(new Mov(destination, regZero));
      break;
    case "%":
      statementList.add(new Mov(regZero, regLHS));
      statementList.add(new Mov(regOne, regRHS));
      statementList.add(new BranchLink(new Label(
          codeState.DIVIDE_BY_ZERO)));
      codeState.checkDivisionByZero();
      statementList.add(new BranchLink(MOD_LABEL));
      statementList.add(new Mov(destination, regOne));
      break;
    case "+":
      statementList.add(new Add(true ,destination, regLHS, regRHS));
      statementList.add(new BranchLink(Cond.VS,
          new Label(codeState.INTEGER_OVERFLOW)));
      codeState.throwOverflow();
      break;
    case "-":
      statementList.add(new Sub(true, destination, regLHS, regRHS));
      statementList.add(new BranchLink(Cond.VS,
          new Label(codeState.INTEGER_OVERFLOW)));
      codeState.throwOverflow();
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
    // registers.freeRegister(destination);
    
    returnedRegister = destination;
    return statementList;
  }

  @Override
  public Deque<Token> visit(UnaryOperExpr unExpr) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    Expr expression = unExpr.getExpr();
    statementList.addAll(expression.accept(this));
    Register regExpr = returnedRegister;
    
    ImmediateValue zeroVal = new ImmediateValue("0");
    ImmediateValue oneVal = new ImmediateValue("1");
    
    switch(unExpr.getOp().getString()) {
    case "!":
      // R4 = R4 && 0 => R4 = !R4
      statementList.add(new Eor(regExpr, regExpr, oneVal));
      break;
    case "-":
      // R5 = 0
      Register regHelper = registers.getGeneralRegister();
      statementList.add(new Mov(regHelper, zeroVal));
      // R4 = R5 - R4 => R4 = -R4
      statementList.add(new Sub(true, regExpr, regHelper, regExpr));
      statementList.add(new BranchLink(Cond.VS,
          new Label(codeState.INTEGER_OVERFLOW)));
      codeState.throwOverflow();
      registers.freeRegister(regHelper);
      break;
    case "ord":
      break;
    case "len":
      statementList.add(new Ldr(regExpr, new Address(regExpr)));
      break;
    case "chr":
      break;
    }
    
    registers.freeRegister(regExpr);
    
    returnedRegister = regExpr;
    return statementList;
  }

  @Override
  public Deque<Token> visit(ValueExpr valueExpr) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    if (valueExpr.getLiter() instanceof ArrayElem) {
      statementList.addAll(((ArrayElem) valueExpr.getLiter()).accept(this));
    }
    else if (valueExpr.getLiter() instanceof PairLiter) {
      Register reg = registers.getGeneralRegister();
      ImmediateValue zeroVal = new ImmediateValue("0");
      zeroVal.setPrefix("=");
      
      statementList.add(new Ldr(reg, zeroVal));
      returnedRegister = reg;
    }
    else if (valueExpr.getType().equals(BaseType.typeInt)) {
      String intValue = valueExpr.getLiter().getString();
      // Find a register to store the value in.
      Register reg = registers.getGeneralRegister();
      if (reg == null) { // 
        statementList.add(new Push(Register.r10));
        stack.add(new ImmediateValue(intValue));
        reg = Register.r10;
      }
      ImmediateValue val = new ImmediateValue(intValue);
      val.setPrefix("=");
      
      statementList.add(new Ldr(reg, val));
      returnedRegister = reg;
    }
    else if (valueExpr.getType().equals(BaseType.typeBool)) {
      int boolValue = ((BoolLiter) (valueExpr.getLiter())).getValue();
      Register reg = registers.getGeneralRegister();
      if (reg == null) { // 
        statementList.add(new Push(Register.r10));
        stack.add(new ImmediateValue(boolValue));
        reg = Register.r10;
      }
      ImmediateValue val = new ImmediateValue(boolValue);
      
      statementList.add(new Mov(reg, val));
      returnedRegister = reg;
    }
    else if (valueExpr.getType().equals(BaseType.typeChar)) {
      String charValue = valueExpr.getString();
      Register reg = registers.getGeneralRegister();
      String c = removeEscapeSlash(charValue);
      ImmediateValue val = new ImmediateValue(c);
      
      if (reg == null) { // 
        statementList.add(new Push(Register.r10));
        stack.add(val);
        reg = Register.r10;
      }

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
    
    return statementList;
  }

  @Override
  public Deque<Token> visit(Variable variable) {
    Deque<Token> statementList = new LinkedList<Token>();
    returnedRegister = registers.getGeneralRegister();
    
    Identifier varName = variable.getScope().lookUpAll(variable.getName()
        , variable.getPosition());
    
    if (variable.getType().equals(BaseType.typeBool) ||
          variable.getType().equals(BaseType.typeChar)) {
      statementList.add(new Ldr(returnedRegister, 
          new Address(Register.sp, (currStackSize - varName.getStackSize()) + 
              varName.getStackPosition()), true));
    }
    else if (variable.getType().equals(BaseType.typeInt)) {
      statementList.add(new Ldr(returnedRegister, 
          new Address(Register.sp, varName.getStackPosition())));
    }
    else {
      statementList.add(new Ldr(returnedRegister, 
          new Address(Register.sp, (currStackSize - varName.getStackSize()) + 
              varName.getStackPosition())));
    }
    
    return statementList;
  }

  @Override
  public Deque<Token> visit(AssignStat assignStat) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    AssignRHS rhs = assignStat.getRhs();

    statementList.addAll(rhs.accept(this));
    Register regRHS = returnedRegister;

    AssignLHS lhs = assignStat.getLhs();
    Identifier name = null;
        
    if (lhs instanceof Variable) {
      name = ((Variable) lhs).getScope().lookUpAll(lhs.getName(), 
          assignStat.getCodePosition());

      if (name.getStackPosition() == -1) {
        currOffset -= getSize(lhs);
        name.setStackPosition(currOffset, currStackSize);
      }
      
      Address assignAddress = new Address(Register.sp, currOffset);
      
      if (name != null) {
        int stackPos = name.getStackPosition();
        assignAddress = new Address(Register.sp, (currStackSize -
            name.getStackSize()) + stackPos);
      }
      
      if (isByte((Variable) lhs)) {
        System.out.println("Hey " + lhs.getType() + lhs.getPosition());
        statementList.add(new Str(regRHS, assignAddress, true));
      }
      else {
        if (regRHS != null) {
          statementList.add(new Str(regRHS, assignAddress));
        }
        else {
          Register tempReg = registers.getGeneralRegister();
          statementList.add(new Str(tempReg, assignAddress));
          registers.freeRegister(tempReg);
        }
      }
    }
    else if (lhs instanceof First) {
      First fst = (First) assignStat.getLhs();
      Register reg = registers.getGeneralRegister();

      statementList.add(new Mov(Register.r0, reg));
      statementList.add(new BranchLink(new Label("p_check_null_pointer")));
      statementList.add(new Str(regRHS, new Address(reg)));
    }
    else if (lhs instanceof Second) {
      Second snd = (Second) assignStat.getLhs();
      Register reg = registers.getGeneralRegister();
      
      statementList.add(new Mov(Register.r0, reg));
      statementList.add(new BranchLink(new Label("p_check_null_pointer")));
      statementList.add(new Str(regRHS, new Address(reg, 4)));
      
    }
    else if (lhs instanceof ArrayElem) {
      name = ((ArrayElem) lhs).getScope().lookUpAll(lhs.getName());
      
      Register arrayReg = registers.getGeneralRegister();
      Register arrayIndexReg = null;
      
      if (name.getStackPosition() == -1) {
        currOffset -= getSize(lhs);
        name.setStackPosition(currOffset, currStackSize);
      }
            
      ImmediateValue offsetValue = new ImmediateValue(currOffset);
      statementList.add(new Add(arrayReg, Register.sp, offsetValue));

      List<Expr> expressionList = ((ArrayElem) lhs).getExpressions();
      Expr expr;
      

      for (int i = 0; i < expressionList.size(); i++) {
        expr = expressionList.get(i);
        statementList.addAll(expr.accept(this));
        arrayIndexReg = returnedRegister;
        
        statementList.add(new Ldr(arrayReg, new Address(arrayReg)));
        statementList.add(new Mov(Register.r0, arrayIndexReg));
        statementList.add(new Mov(Register.r1, arrayReg));

        statementList.add(new BranchLink(new Label(codeState.ARRAY_BOUND)));

        codeState.throwArrayBoundError();
        statementList.add(new Add(arrayReg, arrayReg, 
            new ImmediateValue("4")));
        if (isByte((Expr) rhs) && i == expressionList.size() - 1 
            || isString(rhs.getType())) {
          statementList.add(new Add(arrayReg, arrayReg, arrayIndexReg));
        }
        else {
          statementList.add(new Add(arrayReg, arrayReg, arrayIndexReg, 2));
        }
      }
            
      if (isByte((Expr) rhs)) {
        statementList.add(new Str(regRHS, new Address(arrayReg), true));
      }
      else {
        statementList.add(new Str(regRHS, new Address(arrayReg)));
      }
      registers.freeRegister(arrayReg);
      registers.freeRegister(arrayIndexReg);
    }

    registers.freeRegister(regRHS);
    returnedRegister = regRHS;
    
    return statementList;
  }
  
  private int getSize(AssignLHS lhs) {
    if (lhs.getType().equals(BaseType.typeBool) ||
        lhs.getType().equals(BaseType.typeChar)) {
      return 1;
    }
    return 4;
  }
  
  private boolean isByte(Expr expr) {
    return expr.getType().equals(BaseType.typeBool) || 
        expr.getType().equals(BaseType.typeChar);
  }

  @Override
  public Deque<Token> visit(BeginEndStat beginEnd) {
    Deque<Token> token = new LinkedList<Token>();
    StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
    int scopeOffset = beginEnd.getContent().accept(stackVisitor);
    currStackSize += scopeOffset;
    currOffset += scopeOffset;
    extraOffset = scopeOffset;
    subExtraOffset(token);
    token.addAll(beginEnd.getContent().accept(this));
    addExtraOffset(token);
    currStackSize -= scopeOffset;
    currOffset -= scopeOffset;
    return token;
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
    Deque<Token> statementList = new LinkedList<Token>();
    
    Register reg;
    
    statementList.addAll(freeStat.getItem().accept(this));
    reg = returnedRegister;
    
    statementList.add(new Mov(Register.r0, reg));
    statementList.add(new BranchLink(new Label(codeState.FREE_PAIR) ));
    
    codeState.freePair();
    registers.freeRegister(reg);
    
    msgNum++;
    return statementList;
  }

  @Override
  public Deque<Token> visit(IfThenElseStat ifStat) {
    Deque<Token> statementList = new LinkedList<Token>();
    Expr condition = ifStat.getCondition();
    StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
    statementList.addAll(condition.accept(this));

    Label ifBodyLabel = new Label("L" + (labelCounter * 2));
    Label elseBodyLabel = new Label("L" + (labelCounter * 2 + 1));

    Register reg = returnedRegister;
    
    statementList.add(new Cmp(reg, new ImmediateValue("0")));
    statementList.add(new Branch(Cond.EQ, ifBodyLabel));
    registers.freeRegister(reg);
    labelCounter++;
    
    // Create space in the stack for the ifBody scope.
    int scopeOffset = ifStat.getIf().accept(stackVisitor);
    currStackSize += scopeOffset;
    currOffset += scopeOffset;
    extraOffset = scopeOffset;
    subExtraOffset(statementList);
    statementList.addAll(ifStat.getIf().accept(this));
    addExtraOffset(statementList);
    currOffset -= scopeOffset;
    currStackSize -= scopeOffset;
    
    statementList.add(new Branch(elseBodyLabel));
    statementList.add(ifBodyLabel);
    
    // Create space in the stack for the else scope.
    scopeOffset = ifStat.getElse().accept(stackVisitor);
    currStackSize += scopeOffset;
    currOffset += scopeOffset;
    extraOffset = scopeOffset;
    subExtraOffset(statementList);
    statementList.addAll(ifStat.getElse().accept(this));
    addExtraOffset(statementList);
    currOffset -= scopeOffset;
    currStackSize -= scopeOffset;
    
    statementList.add(elseBodyLabel);
    
    return statementList;
  }

  @Override
  public Deque<Token> visit(ReturnStat returnStat) {
    Deque<Token> statementList = new LinkedList<Token>();
    statementList.addAll(returnStat.getExpr().accept(this));
    Register reg = returnedRegister;
    statementList.add(new Mov(Register.r0, reg));
    statementList.add(new Pop(Register.pc));
    registers.freeRegister(reg);
    return statementList;
  }

  @Override
  public Deque<Token> visit(PrintlnStat printlnStat) {
    if (returnedRegister == null) {
      returnedRegister = registers.getGeneralRegister();
      registers.freeRegister(returnedRegister);
    }
    return  visitPrint(printlnStat.getExpr().accept(this), 
        returnedRegister, printlnStat.getExpr().getType(), true);
  }

  @Override
  public Deque<Token> visit(PrintStat printStat) {
    returnedRegister = registers.getGeneralRegister();
    registers.freeRegister(returnedRegister);
    return visitPrint(printStat.getExpr().accept(this), 
        returnedRegister, printStat.getExpr().getType(), false);
  }
  
  private Deque<Token> visitPrint(Deque<Token> tokens, 
      Register register, Type type, Boolean isLn) {
    
    // String.
    if (isString(type)) {
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
    else {
      tokens.add(new Mov(Register.r0, register));
      tokens.add(new BranchLink(new Label(ArmCodeState.PRINT_REF)));
      codeState.usePrintRef();
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
        Identifier ident = var.getScope().lookUpAll(var.getName(), 
            readStat.getCodePosition());
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
        Identifier ident = var.getScope().lookUpAll(var.getName(),
            readStat.getCodePosition());
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
    Deque<Token> statementList = new LinkedList<Token>();
    StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
    Expr condition = whileStat.getCondition();
    Label startWhile = new Label("L" + labelCounter * 2);
    Label endWhile = new Label("L" + (labelCounter * 2 + 1));
    labelCounter++;
    
    statementList.add(new Branch(startWhile));
    statementList.add(endWhile);
    
    int scopeOffset = whileStat.getBody().accept(stackVisitor);
    currStackSize += scopeOffset;
    currOffset += scopeOffset;
    extraOffset = scopeOffset;
    subExtraOffset(statementList);
    statementList.addAll(whileStat.getBody().accept(this));
    addExtraOffset(statementList);
    currOffset -= scopeOffset;
    currStackSize -= scopeOffset;
    
    statementList.add(startWhile);
    statementList.addAll(condition.accept(this));
    
    statementList.add(new Cmp(returnedRegister, new ImmediateValue("1")));
    statementList.add(new Branch(Cond.EQ, endWhile));
    registers.freeRegister(returnedRegister);
    return statementList;
  }
  
  private String removeEscapeSlash(String charValue) {
    String copyCharValue = charValue;
    int len = copyCharValue.length();
    int slashIndex = -1;
    for (int i=0; i<copyCharValue.length(); i++) {
      if (copyCharValue.charAt(i) == '\\') {
        slashIndex = i;
        break;
      }
    }
    if (slashIndex == -1) {
      return copyCharValue;
    }
    String front = copyCharValue.substring(0, slashIndex);
    String back = copyCharValue.substring(slashIndex + 1, len);
    charValue = front + back;
    return charValue;
  }
}
