package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.LinkedList;

import compiler.backEnd.instructions.Add;
import compiler.backEnd.instructions.AssemblerDirective;
import compiler.backEnd.instructions.BranchLink;
import compiler.backEnd.instructions.Label;
import compiler.backEnd.instructions.Ldr;
import compiler.backEnd.instructions.Mov;
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
    // TODO Auto-generated method stub
    return null;
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
      String literal = valueExpr.getLiter().getString();
      // Find a register to store the value in.
      Register reg = registers.getGeneralRegister();
      ImmediateValue val = new ImmediateValue(literal);
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
    String lhsName = assignStat.getLhs().getName();
    Variable lhsVar = (Variable) assignStat.getLhs();
    lhsVar.accept(this);
    Identifier lhsIdent = lhsVar.getScope().lookUpAll(lhsName);
    
    Expr rhs = (Expr) assignStat.getRhs();
    
    statementList.addAll(rhs.accept(this));
    
    Register regRHS = returnedRegister;
    Address assignAddress = new Address(Register.sp);
    
    statementList.add(new Str(regRHS, assignAddress));
    registers.freeRegister(regRHS);
    
    return statementList;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(WhileStat whileStat) {
    // TODO Auto-generated method stub
    return null;
  }  

}
