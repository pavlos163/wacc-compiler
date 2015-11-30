package compiler.instructionVisit;

public class Instruction {
	private String operator;
	private String arg1;
	private String arg2;

	public Instruction(String operator, String arg1, String arg2) {
		this.operator = operator;
		this.arg1 = arg1;
		this.arg2 = arg2;
	}
	public String getOperator() {
		return this.operator;
	}
	public String getArg1() {
		return this.arg1;
	}
	public String getArg2() {
		return this.arg2;
	}

}
