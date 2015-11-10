/*public class SymbolTable {
  
  private SymbolTable enclosedSymTable;
  private SymbolTable outerSymTable;
  private HashMap<String, ReturnableType> dictonary;


  public SymbolTable(SymbolTable st) {
		dictonary = new HashMap<String, ReturnableType>();
		setEnclosedSymTable(st);
  }

  public void add(String name,ReturnableType obj) {  
  }

  public ReturnableType lookUpCurrLevelOnly(String name) {
		return dictonary.get(name);
  }
  public ReturnableType lookUpCurrLevelAndEnclosingLevels(String name) {
    SymbolTable s = this;
	  while (s != null) {
	    ReturnableType obj = s.lookUpCurrLevelOnly(name);
		if (obj != null) {
		  return obj;
		}
		    s = s.getEnclosedSymTable();
	 }
	return null;
  }
  
  public ReturnableType lookUpCurrLevelAndOuterLevels(String name) {
    while (this != null) {
      SymbolTable s = this;
	ReturnableType obj = s.lookUpCurrLevelOnly(name);
	  if (obj != null) {
	    return obj;
	  }
	   s = s.outSymTable;
      }
         return null;
   }
  public SymbolTable getEnclosedSymTable() {
		return enclosedSymTable;
	}

  public void setEnclosedSymTable(SymbolTable enclosedSymTable) {
		this.enclosedSymTable = enclosedSymTable;
	}


}*/
