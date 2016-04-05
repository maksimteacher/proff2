package AndreyKukuruzaHomeWork.Homework2.Task2;

public abstract class AbstractCalc implements Calculator{
	private String result="";
	private int temp;
	private char operation='0';
	@Override
	public String printResult(){
		System.out.println("Result = " + result);
		return getResult();
	}
	public String getResult(){
		return result;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	public void setResult(String result) {
		this.result = result;
	}	
}
