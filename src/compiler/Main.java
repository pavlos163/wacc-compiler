package wacc.compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.apache.commons.io.FilenameUtils;

public class Main {
  
  public static void main(String[] args) {

    String inputFile = null;
    String outputFile = null;
    Compiler compiler = new Compiler();

    if (args.length != 1) {
      throw new RuntimeException("You must specify exactly one file to be compiled"); 
    }
    
    if (args[0] != null) {
      inputFile = args[0];
    }

    if (!isExtension(inputFile, "wacc") {
      throw new RuntimeException("File to be compiled must be of type .wacc");
    }
    outputFile = removeExtension(inputFile) + ".s";
    
    InputStream input = new FileInputStream(inputFile);
    PrintStream output = new PrintStream(new File(outputFile));
    
    // output.print(compiler.compile(input));
    output.close();

    System.exit(0);
  
  }

}
