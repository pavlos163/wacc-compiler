package compiler.instructions;

import compiler.operands.Operand;

public abstract class Instruction {
  
  protected final Operand source;
  protected final Operand destination;
      
  public Instruction(Operand destination, Operand source) {
    this.destination = destination;
    this.source = source;
  }
  
  public Instruction(Operand destination) {
    this.destination = destination;
    this.source = null;
  }
  
  public Operand getSource() {
    return source;
  }
  
  public Operand getDestination() {
    return destination;
  }
  
}
