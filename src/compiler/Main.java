package compiler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Main {
  
  public static void main(String[] args) throws Exception {
    String inputFile = null;
    String outputFile = null;
    Compiler compiler = new Compiler();
    
    if (args.length != 2) {
      throw new RuntimeException  
        ("You must specify exactly one file to be compiled"); 
    }
    
    if (!isExtension(inputFile, ".wacc")) {
      throw new RuntimeException("File to be compiled must be of type .wacc");
    }
    outputFile = replaceExtension(outputFile, ".s");
    
    InputStream input = new FileInputStream(inputFile);
    PrintStream output = new PrintStream(new File(outputFile));
    
    compiler.compile(input);
    output.close();

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
