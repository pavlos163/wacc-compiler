package compiler.backEnd.instructions;

public interface InstructionVisitor<T> {
  
  T visit(Instruction instr);
  
  T visit(AssemblerDirective dir);
  
}
  