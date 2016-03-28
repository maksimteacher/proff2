package calc;

public abstract class AbstractCalc implements Calculator{
	 protected String result;
	 private int temp;
	 private char operation;
	 @Override
	 public void printResult(){
	  System.out.println("Result = " + result);
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
	
	
	public void execute() {
		int display = Integer.parseInt(result);
//		int t = display;
		boolean error = false;
		switch (operation) {
		case '+' : display += temp; break;
		case '-' : display = temp - display; break;
		case '/' : {
			if (display == 0) {
				error = true;
			} else {
				display = temp / display; 
			}
			break;
		}
		case '*' : display *= temp; break;
		}
//		temp = t;
		if (error) {
			result = ByZero;
		} else {
			result = Integer.toString(display);
		}
		
		
	}
	
	}