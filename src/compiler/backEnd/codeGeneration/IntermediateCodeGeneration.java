package compiler.backEnd.codeGeneration;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

import compiler.backEnd.instructions.AssemblerDirective;
import compiler.backEnd.instructions.Instruction;
import compiler.backEnd.instructions.Label;
import compiler.backEnd.instructions.Ldr;
import compiler.backEnd.instructions.Pop;
import compiler.backEnd.instructions.Push;
import compiler.backEnd.instructions.Token;
import compiler.backEnd.operands.ImmediateValue;
import compiler.backEnd.operands.Register;
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
import compiler.frontEnd.statements.Stat;
import compiler.frontEnd.statements.StatList;
import compiler.frontEnd.statements.WhileStat;

public class IntermediateCodeGeneration implements 
    AbstractSyntaxTreeVisitor<Deque<Token>> {

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
            
      tokens.add(new Label("main"));
      tokens.add(new Push(Register.lr));
                        
      tokens.addAll(bodyStatements);
            
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
    // TODO Auto-generated method stub
    return null;
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
