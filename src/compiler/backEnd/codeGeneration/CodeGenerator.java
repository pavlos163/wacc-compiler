package compiler.backEnd.codeGeneration;

import java.util.Deque;
import java.util.LinkedList;

import compiler.backEnd.instructions.Instruction;
import compiler.backEnd.instructions.PrintingInstrVisitor;
import compiler.backEnd.instructions.Token;

public class CodeGenerator {

  private ASTNode ast;
  public CodeGenerator(ASTNode ast) {
    this.ast = ast;
  }
  
  public String generateCode() {
    IntermediateCodeGeneration visitor = 
        new IntermediateCodeGeneration();
    
    Deque<Token> tokenList = new LinkedList<Token>();
    // This should return a structure with the 
    // the assembly instructions of the program.
    
    Deque<Token> finalCode = ast.accept(visitor);
    
    return generateAssembly(finalCode);
  }

  private String generateAssembly(Deque<Token> finalCode) {
    String assemblyCode = "";
    
    PrintingInstrVisitor printer = new PrintingInstrVisitor();
    
    for (Token token : finalCode) {
      //assemblyCode += printer.visit(token);
    }
    
    return assemblyCode;
  }
}
