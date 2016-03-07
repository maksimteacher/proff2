package calc;

public class Runner {

	public static void main(String[] args) {
		String s = "001/10";
		boolean b = CalculatorLogic.foo(s);
		System.out.println(b);
		if (b) {
		String res = CalculatorLogic.parse(s);
		System.out.println(res);
		} else {
			System.out.println("input error...");
		}
	}

}
