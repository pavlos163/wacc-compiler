package compiler.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
  private SymbolTable parentScope;
  private Map<String, Identifier> dictionary = 
    new HashMap<String, Identifier>();
  
  // The method below is only called when we want to 
  // initialize the top scope.
  public SymbolTable() {
    this.parentScope = null;
  }
  
  public SymbolTable(SymbolTable parent) {
    this.parentScope = parent;
  }

  public void add(String name,Identifier obj) {  
    dictionary.put(name, obj);
  }
  
  // Looks up from the currentScope to the top scope the given variable.
  public Identifier lookUpAll(String name) {
    SymbolTable currentScope = this;
    Identifier element = null;
    while (currentScope != null) {
      element = currentScope.lookUpCurrLevelOnly(name);
      if (element != null) {
        return element;
      }
    }
    return null;
  }
  
  public Identifier lookUpCurrLevelOnly(String name) {
    return dictionary.get(name);
  }
  
}

