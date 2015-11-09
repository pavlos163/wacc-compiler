public class SymbolTable {

  private SymbolTable enclosedSymTable;
  private SymbolTable outerSymTable;
  private HashMap<String, Type> dictonary;


  public SymbolTable(SymbolTable st) {
		dictonary = new HashMap<String, Type>();
		setEnclosedSymTable(st);
  }

  public void add(String name,Type obj) {
  
  }

  public Type lookUpCurrLevelOnly(String name) {
		return dictonary.get(name);
  }

}
