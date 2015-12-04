package compiler.instructions;

import java.util.ArrayList;
import java.util.List;

public interface InstructionVisitor<T> {
  
  //T visit(And and);
  
  //T visit(Orr or);
  
  //T visit(Eor eor);
  
  //T visit(Mov mov);
  
  //T visit(Label label);
    
  T visit(Ldr ldr);
    
  //T visit(Str str);
    
  //T visit(Branch b);
  
  //T visit(Bl bl);
  
  T visit(Push push);
  
  T visit(Pop pop);
  
  //T visit(Cmp cmp);
  
  //T visit(Mul mul);
  
  //T visit(Add add);
  
  //T visit(Sub sub);
  
  //T visit(AssemblerDirective dir);
  
}
  