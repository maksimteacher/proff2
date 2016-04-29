package calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMyCalc {
	MyCalculator calc;
	
	@Before
	public void init() {
		calc = new MyCalculator();
	}
	

	@Test
	public void test() {
		calc.inString("1");
		calc.inString("*");
		calc.inString("1");
		calc.inString("=");
		assertTrue(calc.getOperationInString().compareTo("1") == 0);
	}
	
	@Test
	public void test2() {
		calc.inString("2");
		calc.inString("/");
		calc.inString("0");
		calc.inString("=");
		assertTrue(calc.getOperationInString().compareTo(calc.byZero) == 0);
	}
	
	@Test
	public void test3() {
		calc.inString("2");
		calc.inString("+");
		calc.inString("0");
		calc.inString("=");
		assertTrue(calc.getOperationInString().compareTo("2") == 0);
	}

	@Test
	public void test4() {
		calc.inString("2");
		calc.inString("4");
		calc.inString("-");
		calc.inString("2");
		calc.inString("0");
		calc.inString("=");
		assertTrue(calc.getOperationInString().compareTo("4") == 0);
	}
}
