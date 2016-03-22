package calculator;


public class MyCalculator {
	
	private char lastOperation;
	private String numberInString;
	private String operationInString;
	private int number;
	private int result;
	public final String byZero = "Error!";
	
	public MyCalculator() {
		numberInString = "";
		operationInString = "";
		lastOperation = 'z';
	}
	
	public void reset() {
		numberInString = "";
		lastOperation = 'z';
		result = 0;
		
		if(operationInString != byZero) {
			operationInString = "";
		}
	}
	
	public void inString(String str) {	
		if(operationInString == byZero) {
			operationInString = "";
		}
		
		if(str.matches("[0-9]")) {
			numberInString += str;
			operationInString += str;
			parseLastNumberInString();
		} else if(str.matches("[+-/*]")) {
			numberInString = "";	
			executeOperation();
			lastOperation = str.charAt(0);
			if(operationInString != byZero) {
				operationInString += " " + str + " ";
			} else {
				reset();
			}
		} else if(str.compareTo("=") == 0){
			numberInString = "";
			executeOperation();
			lastOperation = str.charAt(0);
			if(operationInString != byZero) {
				operationInString = "" + result;
			}
		} else if(str.compareTo("c") == 0) {
			reset();
		}
	}
	
	private void executeOperation() {
		switch(lastOperation) {
		case '+': result += number; break;
		case '-': result -= number; break;
		case '*': result *= number; break;
		case '/': {
			if(number != 0) {
				result /= number;	
			} else {
				operationInString = byZero;
				reset();
			}
		} break;
		case 'z': result = number; break;
		}
	}

	public int getResult() {
		return result;
	}

	private void parseLastNumberInString() {
		number = Integer.parseInt(numberInString);
	}

	public String getOperationInString() {
		return operationInString;
	}

}
