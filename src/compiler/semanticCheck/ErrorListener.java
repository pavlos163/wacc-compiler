package compiler.semanticCheck;

import org.antlr.v4.runtime.*;

public class ErrorListener extends BaseErrorListener {
	@Override
  public void syntaxError(Recognizer<?, ?> recognizer,
    Object offendingSymbol, int line, int charPositionInLine,
	String msg, RecognitionException e) 
	{
	System.err.println("#syntax_error#");
	System.exit(100);
	}
}
