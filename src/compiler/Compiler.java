package compiler;

import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.WaccLexer;
import antlr.WaccParser;

public class Compiler {
  
  private ParseTree tree;
  private WaccLexer lexer;
  private WaccParser parser;
  
	public Compiler() {
	}
	
	private void syntacticAnalysis() {
	  this.tree = parser.program();
	}
	
	private void semanticAnalysis() {
	  try {
	    // TODO visit the AST.
	  }catch (Exception e) { // Exception for syntactical errors.
 	    // print to the output the error. Exits the system.
	  }
	  // TODO another catch for the semantical errors.
	}
	
	public void Compile(InputStream code) throws IOException {
	  // WaccAST ast = constructAST(code);
	  // If there is no error we proceed to code generation.
	  
	  initializeParserAndLexer(code);
	  syntacticAnalysis();
	  semanticAnalysis();
	  
	  // If none of the above exited the program then the compiler
	  // proceeds to code generation.
	}
	
	public void initializeParserAndLexer(InputStream code) 
	  throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(code);
		this.lexer = new WaccLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		this.parser = new WaccParser(tokens);
	}
}
