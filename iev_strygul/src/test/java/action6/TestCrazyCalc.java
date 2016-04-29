package action6;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

public class TestCrazyCalc {
	
	CrazyCalc calc;
	int input;
	
	
	@Before
	public void init() {
		calc = new CrazyCalc();
	}
	
	@Test
	public void test1() {
		input = 5;
		calc.operation(input);
		assertTrue(calc.get()==5);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test2() {
		input = -5;
		calc.operation(input);
		calc.get();
	}
	
	@Test
	public void test3() {
		input = 0;
		calc.operation(input);
		assertTrue(calc.get()==0);
	}
}
