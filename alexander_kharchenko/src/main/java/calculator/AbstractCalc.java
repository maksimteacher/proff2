package calculator;

public abstract class AbstractCalc implements Calculator {
	private String result;
	private int temp;
	private char operation;

	public AbstractCalc() {
		result = "0";
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

	@Override
	public void printResult() {
		System.out.println("Result = " + result);
	}

	public String getResult() {
		return result;
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

	@Override
	public String toString() {
		return "AbstractCalc [result=" + result + ", temp=" + temp + ", operation=" + operation + "]";
	}
	
}