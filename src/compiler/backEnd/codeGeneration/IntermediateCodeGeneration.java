package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.LinkedList;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.And;
import compiler.backEnd.instructions.AssemblerDirective;
import compiler.backEnd.instructions.BranchLink;
import compiler.backEnd.instructions.Cmp;
import compiler.backEnd.instructions.Cond;
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
import compiler.frontEnd.types.BaseType;

public class IntermediateCodeGeneration implements 
    AbstractSyntaxTreeVisitor<Deque<Token>> {
  
  RegisterList registers = new RegisterList();
  Register returnedRegister = null;

  @Override
  public Deque<Token> visit(ProgramNode programNode) {
    Deque<Token> tokens = new LinkedList<Token>();
    try {
      // First we visit the functions and generate the code.
      IntermediateCodeGeneration codeGen = 
          new IntermediateCodeGeneration();
      for (Function func : programNode.getFunctions()) {
        tokens.addAll(func.accept(codeGen));
      }
            
      tokens.add(new AssemblerDirective(".text"));
      tokens.add(new AssemblerDirective(".global main"));
      
      Deque<Token> bodyStatements = 
          programNode.getStatements().accept(codeGen);
            
      // TODO: Handle stack.
            
      tokens.add(new Label("main:"));
      tokens.add(new Push(Register.lr));
      
      StackOffsetVisitor stackVisitor = new StackOffsetVisitor();
      int stackOffset = programNode.getStatements().accept(stackVisitor);
      ImmediateValue val = new ImmediateValue(stackOffset);

      if (stackOffset > 0) {
        tokens.add(new Sub(Register.sp, Register.sp, val));
      }
      
      tokens.addAll(bodyStatements);

      if (stackOffset > 0) {
        tokens.add(new Add(Register.sp, Register.sp, val));
      }
      
      ImmediateValue value = new ImmediateValue("0");
      value.setPrefix("=");
      
      tokens.add(new Ldr(Register.r0, value));
      tokens.add(new Pop(Register.pc));
      tokens.add(new AssemblerDirective(".ltorg"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return tokens;
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
    
    Expr lhs = binExpr.getLHS();
    statementList.addAll(lhs.accept(this));
    Register regLHS = registers.getGeneralRegister();
    
    Expr rhs = binExpr.getRHS();
    statementList.addAll(rhs.accept(this));
    Register regRHS = registers.getGeneralRegister();
    
    registers.freeRegister(regLHS);
    registers.freeRegister(regRHS);
    
    Register destination = registers.getGeneralRegister();
    
    ImmediateValue exprTrue = new ImmediateValue("1");
    ImmediateValue exprFalse = new ImmediateValue("0");
    
    switch(binExpr.getBinOp().getString()) {
    case "*":
      statementList.add(new Mul(destination, regLHS, regRHS));
    case "/":
      
    case "%":
      
    case "+":
      statementList.add(new Add(destination, regLHS, regRHS));
    case "-":
      statementList.add(new Sub(destination, regLHS, regRHS));
    case ">":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.GT, destination, exprTrue));
      statementList.add(new Mov(Cond.LE, destination, exprFalse));
    case ">=":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.GE, destination, exprTrue));
      statementList.add(new Mov(Cond.LT, destination, exprFalse));
    case "<":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.LT, destination, exprTrue));
      statementList.add(new Mov(Cond.GE, destination, exprFalse));
    case "<=":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.LE, destination, exprTrue));
      statementList.add(new Mov(Cond.GT, destination, exprFalse));
    case "==":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.EQ, destination, exprTrue));
      statementList.add(new Mov(Cond.NE, destination, exprFalse));
    case "!=":
      statementList.add(new Cmp(regLHS, regRHS));
      
      statementList.add(new Mov(Cond.NE, destination, exprTrue));
      statementList.add(new Mov(Cond.EQ, destination, exprFalse));
    case "&&":
      statementList.add(new And(destination, regLHS, regRHS));
    case "||":
      statementList.add(new Orr(destination, regLHS, regRHS));
    }
    return statementList;
  }

  @Override
  public Deque<Token> visit(UnaryOperExpr unExpr) {
    // TODO Auto-generated method stub
    return null;
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
    }
    return statementList;
  }

  @Override
  public Deque<Token> visit(Variable variable) {
    Deque<Token> statementList = new LinkedList<Token>();
    returnedRegister = registers.getGeneralRegister();

    return statementList;
  }

  @Override
  public Deque<Token> visit(AssignStat assignStat) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    // For now (if we suppose all LHS to be just variables.
    
    AssignRHS rhs = assignStat.getRhs();
    statementList.addAll(rhs.accept(this));
    
    AssignLHS lhs = assignStat.getLhs();
    
    if (lhs instanceof First) {
      
    }
    else if (lhs instanceof Second) {
      
    }
    else if (lhs instanceof ArrayElem) {
      
    }
    else {
      Register regRHS = registers.getGeneralRegister();
      Address assignAddress = new Address(Register.sp);
      
      if (isByte((Variable) lhs)) {
        statementList.add(new Str(regRHS, assignAddress, true));
      }
      else {
        statementList.add(new Str(regRHS, assignAddress));
      }
      
      registers.freeRegister(regRHS);
    }
    
    return statementList;
  }
  
  private boolean isByte(Variable var) {
    return var.getType().equals(BaseType.typeBool) || 
        var.getType().equals(BaseType.typeChar);
  }

  @Override
  public Deque<Token> visit(BeginEndStat beginEnd) {
    // TODO Auto-generated method stub
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
    registers.freeRegister(Register.r0);
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(ReturnStat returnStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(PrintlnStat printlnStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(PrintStat printStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(ReadStat readStat) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(SkipStat skipStat) {
    return new LinkedList<Token>();
  }

  @Override
  public Deque<Token> visit(StatList statList) {
    Deque<Token> statementList = new LinkedList<Token>();
    
    for (ASTNode statement : statList.getChildren()) {
      statementList.addAll(statement.accept(this));
    }
    return statementList;
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
