package compiler.backEnd.instructions;

public interface Token {
  
  <T> T accept(InstructionVisitor<T> visitor);
  
}