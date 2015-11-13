package compiler.assignables;

import compiler.CodePosition;
import compiler.types.Type;

public class Call implements AssignRHS {
  
  private final String name;
  private final ArgList argList;
  private final CodePosition codePos;
  
  public Call(String name, ArgList argList, CodePosition codePos) {
    this.name = name;
    this.argList = argList;
    this.codePos = codePos;
  }

  // It doesn't have a type.
  @Override
  public Type getType() {
    return null;
  }

  @Override
  public CodePosition getPosition() {
    // TODO Auto-generated method stub
    return null;
  }

}