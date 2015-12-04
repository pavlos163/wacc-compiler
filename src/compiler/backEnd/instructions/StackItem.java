package compiler.backEnd.instructions;

import compiler.frontEnd.types.Type;

public class StackItem {

  private Type type;
  private int stackPosition;
  private boolean param;

  public StackItem(Type type) {
    this.type = type;
    this.param = true;
  }

  public StackItem(Type type, int stackPos) {
    this.type = type;
    this.stackPosition = stackPos;
    this.param = false;
  }

  public Type getType() {
    return this.type;
  }
  
  public int getStackPos() {
    return this.stackPosition;
  }
  
  public boolean getParam() {
    return this.param;
  }
  
}