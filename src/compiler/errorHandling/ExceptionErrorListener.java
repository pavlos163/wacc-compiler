package compiler.errorHandling;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;

public class ExceptionErrorListener extends BaseErrorListener {
  
  public static final ExceptionErrorListener INSTANCE = 
      new ExceptionErrorListener();
  
  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
      int line, int charPositionInLine, String msg, RecognitionException e) 
      throws ParseCancellationException {
    throw new ParseCancellationException("At: " + line + ":" + charPositionInLine + msg);
  }
    
}
