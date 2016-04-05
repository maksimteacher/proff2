package action6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestCrazyCalc {
	private CrazyCalc calc;

	
	@Before
	public void init() {
		calc = new CrazyCalc();
	}

	@Test(expected = ArithmeticException.class)
//	@Test(timeout = 100)
	public void test1() {
		int a = -5;
		calc.operation(a);
		calc.get();
	}

	@Test
	public void test2() {
		int a = 0;
		calc.operation(a);
		assertTrue(0 == calc.get());
	}

	@Test
	public void test3() {
		int a = 5;
		calc.operation(a);
		assertTrue(5 == calc.get());
	}
	
	
}
