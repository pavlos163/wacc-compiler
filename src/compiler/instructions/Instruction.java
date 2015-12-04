package compiler.instructions;

import compiler.operands.Operand;

public abstract class Instruction {
  
  protected Cond cond = null;
  
  protected final Operand destination;
  protected final Operand primarySource;
  protected final Operand secondarySource;
  
  public Instruction(Cond cond, Operand destination, Operand source) {
    this.cond = cond;
    this.destination = destination;
    this.primarySource = source;
    this.secondarySource = null;
  }
      
  public Instruction(Operand destination, Operand source) {
    this.destination = destination;
    this.primarySource = source;
    this.secondarySource = null;
  }
  
  public Instruction(Cond cond, Operand destination, Operand primarySource,
      Operand secondarySource) {
    this.cond = cond;
    this.destination = destination;
    this.primarySource = primarySource;
    this.secondarySource = secondarySource;
  }
  
  public Instruction(Operand destination, Operand primarySource,
      Operand secondarySource) {
    this.destination = destination;
    this.primarySource = primarySource;
    this.secondarySource = secondarySource;
  }
  
  public Instruction(Operand destination) {
    this.destination = destination;
    this.primarySource = null;
    this.secondarySource = null;
  }
  
  public Cond getCond() {
    return cond;
  }
  
  public Operand getSource() {
    return primarySource;
  }
  
  public Operand getSecondarySource() {
    return secondarySource;
  }
  
  public Operand getDestination() {
    return destination;
  }
  
}
