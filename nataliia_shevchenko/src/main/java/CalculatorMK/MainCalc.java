package CalculatorMK;


public class MainCalc {
	public static void main(String[] args) {
		Calculator calc = new Calc1();
		String str = "177*10=";
		for(char p:str.toCharArray()){
			System.out.println("Input "+p);
			calc.inChar(p);
			System.out.println();
		}
	}
	
}
