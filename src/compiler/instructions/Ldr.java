package compiler.instructions;

import compiler.operands.Operand;

public class Ldr extends Instruction {

  public Ldr(Operand destination, Operand source) {
    super(destination, source);
  }
  
  @Override
  public String toString() {
    return "LDR " + destination + " " + source;
  }

}
