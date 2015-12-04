package compiler;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.WaccLexer;
import antlr.WaccParser;
import compiler.backEnd.codeGeneration.ASTNode;
import compiler.backEnd.codeGeneration.CodeGenerator;
import compiler.frontEnd.errorHandling.ExceptionErrorListener;
import compiler.frontEnd.errorHandling.SemanticException;
import compiler.frontEnd.errorHandling.SyntaxException;
import compiler.frontEnd.semanticCheck.SemanticCheckVisitor;

public class Compiler {
  
  private ParseTree tree;
  private WaccLexer lexer;
  private WaccParser parser;
  
  public Compiler() {
  }
	
  private void syntaxAnalysis() {
    try {
      this.tree = parser.program();
    } catch (ParseCancellationException e) {
      System.err.println(e.getMessage());
      System.exit(100);
    }
  }
	
  private ASTNode semanticAnalysis() {
    ASTNode ast = null;
    try {
      ast = (ASTNode) tree.accept(new SemanticCheckVisitor());
    } catch (SyntaxException e) {
      System.err.println(e.getMessage());
      System.exit(100);
    }
    catch (SemanticException e) {
      System.err.println(e.getMessage());
      System.exit(200);
    }
    return ast;
  }
	
  public String compile(InputStream code) throws IOException {
    initializeParserAndLexer(code);
    // Perform syntax and semantic analysis.
    syntaxAnalysis();
    ASTNode ast = semanticAnalysis();
    // If there is no error proceed to code generation.
    
    return new CodeGenerator(ast).generateCode();
  }
	
  public void initializeParserAndLexer(InputStream code) 
	  throws IOException {
    ANTLRInputStream input = new ANTLRInputStream(code);
    this.lexer = new WaccLexer(input);
    lexer.removeErrorListeners();
    lexer.addErrorListener(ExceptionErrorListener.INSTANCE);
    
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    
    this.parser = new WaccParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(ExceptionErrorListener.INSTANCE);
  }
	
}
