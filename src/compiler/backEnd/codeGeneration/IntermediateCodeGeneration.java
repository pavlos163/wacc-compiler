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
import compiler.backEnd.instructions.Token;
import compiler.backEnd.codeGeneration.ArmCodeState;
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
import compiler.frontEnd.types.ArrType;
import compiler.frontEnd.types.BaseType;
import compiler.frontEnd.types.Type;

public class IntermediateCodeGeneration implements 
    AbstractSyntaxTreeVisitor<Deque<Token>> {
  
  private RegisterList registers = new RegisterList();
  private Register returnedRegister = null;
  private ArmCodeState codeState = new ArmCodeState();
  
  @Override
  public Deque<Token> visit(ProgramNode programNode) {
    Deque<Token> tokens = new LinkedList<Token>();
    try {
      // First we visit the functions and generate the code.
      
      for (Function func : programNode.getFunctions()) {
        tokens.addAll(func.accept(this));
      }
      
      tokens.add(new AssemblerDirective(".text"));
      tokens.add(new AssemblerDirective(".global main"));
      
      Deque<Token> bodyStatements = 
          programNode.getStatements().accept(this);
      
      // TODO: Handle stack.
            
      tokens.add(new Label("main:"));
      tokens.add(new Push(Register.lr));
                        
      tokens.addAll(bodyStatements);
            
      ImmediateValue value = new ImmediateValue("0");
      value.setPrefix("=");
      
      tokens.add(new Ldr(Register.r0, value));
      tokens.add(new Pop(Register.pc));
      tokens.add(new AssemblerDirective(".ltorg"));
      // After main label code.
      tokens.addAll(codeState.getAfterMainLabelCode());
      
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
      
    }
    else if (valueExpr.getType().equals(BaseType.typeChar)) {
      
    }
    else if (valueExpr.getType().equals(new ArrType(BaseType.typeChar))) {
      Register reg = registers.getGeneralRegister();
      ImmediateValue val = new ImmediateValue("string");
      val.setPrefix("=");
      statementList.add(new Ldr(reg, val));
      returnedRegister = reg;
    }
    return statementList;
  }

  @Override
  public Deque<Token> visit(Variable variable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Deque<Token> visit(AssignStat assignStat) {
    // TODO Auto-generated method stub
    return null;
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
    statementList.add(new Mov(Register.r0, returnedRegister));
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
    
    if (isLn) {
      tokens.add(new BranchLink(new Label(ArmCodeState.PRINT_LN)));
      codeState.usePrintln();
    }
    
    return tokens;
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

}
