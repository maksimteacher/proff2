package action04_homework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalcResultProff2Example {
	private Calculator calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calc1();
	}

	public void inputString(String str) {
		char[] arr = str.toCharArray();
		for(char ch: arr){
			calc.inChar(ch);			 
		}		
	}

	@Test
	public void testResPlus() {
		String number1 = "" + (int)(1000*Math.random());
		int num1 = Integer.parseInt(number1);
		String number2 = "" + (int)(1000*Math.random());
		int num2 = Integer.parseInt(number2);
		
		String str = number1+"+"+number2+"=";
		inputString(str);
		String expected = num1+num2+"";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResPlus1() {
		String number1 = "0043";
		int num1 = Integer.parseInt(number1);
		String number2 = "0012";
		int num2 = Integer.parseInt(number2);
		
		String str = number1+"+"+number2+"=";
		inputString(str);
		String expected = num1+num2+"";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResMinus() {
		String number1 = "" + (int)(1000*Math.random());
		int num1 = Integer.parseInt(number1);
		String number2 = "" + (int)(1+1000*Math.random());
		int num2 = Integer.parseInt(number2);
		
		String str = number1+"-"+number2+"=";
		inputString(str);
		String expected = num1-num2+"";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResMultiplyTest1() {
		String number1 = "" + (int)(1000*Math.random());
		String number2 = "0";
		
		String str = number1+"*"+number2+"=";
		inputString(str);
		String expected = "0";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResMultiplyTest2() {
		String number1 = "0";
		String number2 = "" + (int)(1000*Math.random());
		
		String str = number1+"*"+number2+"=";
		inputString(str);
		String expected = "0";
		String fact = calc.printResult();
		assertEquals("test_divide("+number1+","+number2+")",expected, fact);
	}
	@Test
	public void testResMultiplyTest3() {
		String number1 = "" + (int)(1000*Math.random());
		int num1 = Integer.parseInt(number1);
		String number2 = "" + (int)(1000*Math.random());
		int num2 = Integer.parseInt(number2);
		
		String str = number1+"*"+number2+"=";
		inputString(str);
		String expected = num1*num2+"";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResMultiplyTest4() {
		String number1 = "1";
		int num1 = Integer.parseInt(number1);
		String number2 = "" + (int)(1000*Math.random());
		int num2 = Integer.parseInt(number2);
		
		String str = number1+"*"+number2+"=";
		inputString(str);
		String expected = num1*num2+"";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResDivideTest1() {
		String number1 = "" + (int)(1000*Math.random());
		int num1 = Integer.parseInt(number1);
		String number2 = "" + (int)(1+1000*Math.random());
		int num2 = Integer.parseInt(number2);
		
		String str = number1+"/"+number2+"=";
		inputString(str);
		String expected = num1/num2+"";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}
	@Test
	public void testResDivideTest2() {
		String number1 = "0";
		String number2 = "" + (int)(1+1000*Math.random());
		
		String str = number1+"/"+number2+"=";
		inputString(str);
		String expected = "0";
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}	
	@Test
	public void testResDivideTest3() {
		String number1 = "" + (int)(1+1000*Math.random());
		String number2 = "0";
		
		String str = number1+"/"+number2+"=";
		inputString(str);
		String expected = calc.ByZero;
		String fact = calc.printResult();
		assertEquals(expected, fact);
	}	
}
