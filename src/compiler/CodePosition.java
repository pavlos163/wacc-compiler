package compiler;

public class CodePosition implements Comparable<CodePosition> {
  
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

  @Override
  public int compareTo(CodePosition arg0) {
    if (this.lineNum < arg0.lineNum) {
      return -1;
    }
    else if (this.lineNum == arg0.lineNum) {
      if (this.charNum < arg0.charNum) {
        return -1;
      }
      else if (this.charNum == arg0.charNum) {
        return 0;
      }
    }
    return 1;
  }
  
}
