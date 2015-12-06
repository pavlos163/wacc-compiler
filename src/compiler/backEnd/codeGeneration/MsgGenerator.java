package compiler.backEnd.codeGeneration;

import compiler.backEnd.instructions.Label;

public class MsgGenerator {
  
  private int n;
  
  public MsgGenerator() {
    this.n = 0;
  }
  
  public Label generateMsg() {
    String msg = "msg_" + n;
    n++;
    return new Label(msg);
  }
}
