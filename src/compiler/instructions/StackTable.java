package compiler.instructions;

import java.util.HashMap;

public class StackTable {

	private StackTable encSymTable;
	private HashMap<String, StackItem> dictonary;

	public StackTable(StackTable st) {
		dictonary = new HashMap<String, StackItem>();
		setEncSymTable(st);
	}

	public void add(String name, StackItem obj) {
		dictonary.put(name, obj);
	}

	public StackItem lookUpCurrLevelOnly(String name) {
		return dictonary.get(name);
	}

	public StackItem lookUpCurrLevelAndEnclosingLevels(String name) {
		StackTable s = this;
		while (s != null) {
			StackItem obj = s.lookUpCurrLevelOnly(name);
			if (obj != null) {
				return obj;
			}
			s = s.getEncSymTable();
		}
		return null;
	}

	public void setEncSymTable(StackTable encSymTable) {
		this.encSymTable = encSymTable;
	}

	public StackTable getEncSymTable() {
		return encSymTable;
	}

}
