package compiler;

public class CodePosition {
  
  /* Class that represents the position of a specific token in the code. */
  
  private int lineNum,charNum;
  
  public CodePosition(int lineNum, int charNum) {
    this.lineNum = lineNum;
    this.charNum = charNum;
  }
  
  public CodePosition getPosition() {
    return this;
  }
  
  @Override
  public String toString() {
    return lineNum + ":" + charNum;
  }
  
}
