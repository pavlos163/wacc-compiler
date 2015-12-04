package compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
  
  /* Implements the whole procedure including handling input and output,
   * compiling the input file and creating the generated output file. */
  
  public static void main(String[] args) throws Exception {
    String inputFile = null;
    String outputFile = null;
    Compiler compiler = new Compiler();
    
    if (args.length != 1) {
      throw new RuntimeException
        ("You must specify exactly one file to be compiled"); 
    }
    
    inputFile = args[0];
    
    if (!isExtension(inputFile, ".wacc")) {
      throw new RuntimeException("File to be compiled must be of type .wacc");
    }
    outputFile = replaceExtension(inputFile, ".s");
    
    InputStream input = new FileInputStream(inputFile);
    PrintStream output = new PrintStream(new File(outputFile));
    
    output.print(compiler.compile(input));
    output.close();
    
    // Program exits properly.
    System.exit(0);
  }

  private static boolean isExtension(String fileName, String extension) {
    String current = fileName.substring(fileName.lastIndexOf('.'));
    return current.equals(extension);
  }

  private static String replaceExtension(String fileName, String extension) {
    return fileName.substring(0, fileName.lastIndexOf('.')) + extension;
  }

}
