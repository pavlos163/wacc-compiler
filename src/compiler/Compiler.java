package compiler;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.RecognitionException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import compiler.errorHandling.SemanticException;
import compiler.errorHandling.SyntaxException;
import compiler.semanticCheck.SemanticCheckVisitor;

import antlr.WaccLexer;
import antlr.WaccParser;

public class Compiler {
  
  private ParseTree tree;
  private WaccLexer lexer;
  private WaccParser parser;
  
  public Compiler() {
  }
 
  private void syntacticAnalysis() {
    try {
      this.tree = parser.program();
    } catch (Exception e) {
      System.exit(100);
    }
  }
	
  private void semanticAnalysis() {
    
    try {
      tree.accept(new SemanticCheckVisitor());
      } catch (SyntaxException e) { // Exception for syntax errors.
        System.err.println(e.getMessage());
        System.exit(100);
      } catch (SemanticException e) {
        System.err.println(e.getMessage());
        System.exit(200);
     }
  }
	
  public void compile(InputStream code) throws IOException {
    initializeParserAndLexer(code);
    syntacticAnalysis();
    // Prints for debugging purposes.
    System.out.print("Syntax analysis has been completed.\n");
    semanticAnalysis();
    System.out.print("Semantic analysis has been completed.\n");
    // If none of the above exited the program then the compiler
    // proceeds to code generation.
    System.exit(0);
  }
	
  public void initializeParserAndLexer(InputStream code) 
	  throws IOException {
    ANTLRInputStream input = new ANTLRInputStream(code);
    this.lexer = new WaccLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    this.parser = new WaccParser(tokens);
  }
	
}
