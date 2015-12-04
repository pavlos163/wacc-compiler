package compiler.backEnd.codeGeneration;

public class CodeGenerator {

  private ASTNode ast;
  public CodeGenerator(ASTNode ast) {
    this.ast = (ProgramNode) ast;
  }
  
  public String generateCode() {
    IntermediateCodeGeneration visitor = 
        new IntermediateCodeGeneration();
    
    // This should return a structure with the 
    // the assembly instructions of the program.
    
    // ast.accept(visitor);
    
    return null;
  }
}
