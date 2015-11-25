package instructionVisit;

public class Register {
  private String name;
  private boolean isFree;
  public Register(String name){
    this.name = name;
    this.isFree = true;
	}
  public String getName(){
    return this.name;
  }
  public boolean isFree(){
    return this.isFree;
  }
}
