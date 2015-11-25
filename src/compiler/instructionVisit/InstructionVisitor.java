package instructionVisit;

import java.util.ArrayList;
import java.util.List;

public class InstructionVisitor {
  private List<Instruction> output;
  private List<Register> registers;
  private Register r0;
  private Register r1;
  private Register r2;
  private Register r3;
  private Register sp;
  private Register lr;
  private Register pc;

  public InstructionVisitor() {
    output = new ArrayList<Instruction>();
	registers = new ArrayList<Register>();
	  
  }
}
  