package alexCalc;

public class Calc extends AbstractCalc {
	private boolean stop;
	
	public Calc() {
		stop = true;
	}
	
	@Override
	public void inChar(char p) {
		if (p == '=') {
			execute();
//			setOperation(' ');
			stop = true;
			System.out.println(this);
			return;
		}
		if (p == '+' || p == '-' || p == '/' || p == '*') {
			setOperation(p);
			setTemp(Integer.parseInt(getResult()));
//			setResult("0");
			stop = true;
			return;
		}
		if (p == '0') {
			if (getResult().equals("0")) {
				System.out.println("skip 0.");
				return;
			}
		}
		setResult(stop ? "" + p : getResult() + p);
		stop = false;
		return;
	}

}
