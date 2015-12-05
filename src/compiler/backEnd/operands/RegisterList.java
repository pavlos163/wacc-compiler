package compiler.backEnd.operands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RegisterList {
  
  private static final int MIN_RETURN_REG = 0;
  private static final int MAX_RETURN_REG = 3;
  
  private static final int MIN_GENERAL_REG = 4;
  private static final int MAX_GENERAL_REG = 11;
  
  private Map<Integer, Register> registerList = 
      new HashMap<Integer, Register>();
  private Set<Register> usedRegisters = new HashSet<Register>();
  
  public RegisterList() {
    for (Register reg : Register.values()) {
      int registerNumber = reg.ordinal();
      registerList.put(registerNumber, reg);
    }
  }
  
  public Register getReturnRegister() {
    Register reg = getRegister(MIN_RETURN_REG, MAX_RETURN_REG);
    usedRegisters.add(reg);
    
    return reg;
  }
  
  public Register getGeneralRegister() {
    Register reg = getRegister(MIN_GENERAL_REG, MAX_GENERAL_REG);
    usedRegisters.add(reg);
    
    return reg;
  }
  
  public Register getRegister(int minRegister, int maxRegister) {
    for (int i = minRegister; i < maxRegister; i++) {
      Register reg = registerList.get(i);
      if (!usedRegisters.contains(reg)) {
        usedRegisters.add(reg);
      }
      return reg;
    }
    return null;
  }
  
  public boolean isUsed(Register reg) {
    return usedRegisters.contains(reg);
  }
  
  public void freeRegister(Register reg) {
    usedRegisters.remove(reg);
  }
  
  public Set<Register> getUsedRegisters() {
    return usedRegisters;
  }
  
}
