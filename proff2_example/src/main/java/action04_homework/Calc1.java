package action04_homework;

public class Calc1 extends AbstractCalc {
	@Override
	public void inChar(char p) {		
		if (p == '=') {
			int valueResult = Integer.parseInt(getResult());
			switch (getOperation()) {
			case '+': setResult(getTemp() + valueResult + ""); break;
			case '-': setResult(getTemp() - valueResult + ""); break;
			case '*': setResult(getTemp() * valueResult  + ""); break;
			case '/': setResult(divide(getTemp(), valueResult)); break;
			}
			setOperation('0');
			setTemp(0);
		} else if ('0' <= p && p <= '9') {
			if(getOperation()!='0' && getTemp()==0){
				setTemp(Integer.parseInt(getResult()));
				setResult("0");
			}
			setResult(getResult() + p);
		} else { // operation + - * /
			setOperation(p);
		}
		printResult();
	}

	@Override
	public void setResult(String value) {
		try {
			value = "" + Integer.parseInt(value);
		} catch (Exception e) {
		}
		super.setResult(value);
	}
	public String divide(int arg1,int arg2){
		if(arg2==0) return ByZero;
		return arg1/arg2+"";
	}
}
