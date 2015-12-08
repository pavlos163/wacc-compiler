package compiler.backEnd.instructions;

import compiler.backEnd.operands.Operand;
import compiler.backEnd.operands.Register;

public abstract class Instruction implements Token {
  
  protected Cond cond = Cond.AL;
  protected boolean s = false;
  protected final Operand destination;
  protected final Operand primarySource;
  protected Operand secondarySource = null;
  protected Operand reg = null; // Overflow reg.
  protected int offset = 0;
  
  public Instruction(boolean s, Operand destination , Operand reg, 
      Operand primarySource, Operand secondarySource) {
    this.s = s;
    this.reg = reg;
    this.destination = destination;
    this.primarySource = primarySource;
    this.secondarySource = secondarySource;
  }
  
  public Instruction(boolean s, Operand destination, Operand primarySource,
      Operand secondarySource) {
    this.s = s;
    this.destination = destination;
    this.primarySource = primarySource;
    this.secondarySource = secondarySource;
  }
  
  public Instruction(Cond cond, Operand destination, Operand source) {
    this.cond = cond;
    this.destination = destination;
    this.primarySource = source;
  }
      
  public Instruction(Operand destination, Operand source) {
    this.destination = destination;
    this.primarySource = source;
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
  }
  
  public Instruction(Operand destination, Operand primarySource, 
      Operand secondarySource, int offset) {
    this.destination = destination;
    this.primarySource = primarySource;
    this.secondarySource = secondarySource;
    this.offset = offset;
  }
  
  public Cond getCond() {
    return cond;
  }
  
  public Operand getPrimarySource() {
    return primarySource;
  }
  
  public Operand getSecondarySource() {
    return secondarySource;
  }
  
  public Operand getDestination() {
    return destination;
  }
  
  public Operand getOverflowReg() {
    return reg;
  }
  
  public int getOffset() {
    return offset;
  }
}
