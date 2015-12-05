package compiler.backEnd.instructions;

public interface InstructionVisitor<T> {
    
  T visit(Instruction instr);
  
  T visit(AssemblerDirective dir);

  T visit(BranchLink branchLink);
  
  T visit(Branch branch);

  T visit(Label label);
  
}
  