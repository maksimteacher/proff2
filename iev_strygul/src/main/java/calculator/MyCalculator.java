package calculator;


public class MyCalculator {
	
	private char lastOperation;
	private String numberInString;
	private String operationInString;
	private int number;
	private int result;
	public final String byZero = "Error! Cannot devide by zero!";
	
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
				operationInString += " " + str;
			} else {
				reset();
			}
		} else if(str.compareTo("=") == 0){
			numberInString = "";
			executeOperation();
			lastOperation = str.charAt(0);
			if(operationInString != byZero) operationInString = "" + result;
		}
	}

	private void executeOperation() {
		if(lastOperation == '+') {
			result += number;
		} else if(lastOperation == '-') {
			result -= number;
		} else if(lastOperation == '*') {
			result *= number;
		} else if(lastOperation == '/') {
			if(number != 0) {
				result /= number;	
			} else {
				operationInString = byZero;
				reset();
			}
		} else if(lastOperation == 'z'){
			result = number;
		}
		
	}

	private void parseLastNumberInString() {
		number = Integer.parseInt(numberInString);
	}

	public String getOperationInString() {
		return operationInString;
	}

}
