package compiler;

public class CodePosition {
  
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
