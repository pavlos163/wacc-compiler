package compiler.backEnd.instructions;

// Visits instructions and generates assembly code accordingly.

public class PrintingInstrVisitor implements InstructionVisitor<String> {
  
  private String ident(int tabs) {
    String str = "\n";
    for (int i = 0; i < tabs; i++) {
      str += "\t";
    }
    return str;
  }
  
  // For all the subtypes of Instruction (MOV, MUL, CMP, B etc.) the printing 
  // message depends only on the toString() method of that instruction. For
  // that reason we don't need to make a visit method for each type.
  
  @Override
  public String visit(Label label) {
    return "\n" + label.toString();
  }
  
  @Override
  public String visit(AssemblerDirective dir) {
    String value = dir.getValue();
    if (value.equals(".ltorg")) {
      return ident(1) + dir.toString();
    }
    else if (value.equals(".global main")) {
      return "\n" + dir.toString();
    }
    return dir.toString() + "\n";
  }
  
  @Override
  public String visit(Instruction instr) {
    return ident(1) + instr.toString();
  }
  
  @Override
  public String visit(Branch instr) {
    return ident(1) + instr.toString();
  }

  @Override
  public String visit(BranchLink instr) {
    return ident(1) + instr.toString();
  }
    
}
