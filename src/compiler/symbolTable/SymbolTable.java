package compiler.symbolTable;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable<T extends Identifier> {
  private SymbolTable<T> parentScope;
  private Map<String, T> dictionary = 
    new HashMap<String, T>();
  
  // The method below is only called when we want to 
  // initialize the top scope.
  public SymbolTable() {
    this.parentScope = null;
  }
  
  public SymbolTable(SymbolTable<T> parent) {
    this.parentScope = parent;
  }

  public void add(String name,T obj) {  
    dictionary.put(name, obj);
  }
  
  // Looks up from the currentScope to the top scope the given variable.
  public Identifier lookUpAll(String name) {
    SymbolTable<T> currentScope = this;
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
  
  public SymbolTable<T> newScope() {
    return new SymbolTable<T>(this);
  }
  
  public SymbolTable<T> getParentScope() {
    return parentScope;
  }
}

