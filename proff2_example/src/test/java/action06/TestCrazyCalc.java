package action06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestCrazyCalc {
	CrazyCalc calc;

	@Before
	public void init() {
		calc = new CrazyCalc();
	}

	@Test
	public void testZero() {
		calc.operation(0);
		int k = calc.get();
		assertTrue("Check by zero", k == 0);
	}

	@Test
	public void testPositiveNumber() {
		int num = (int) (1 + 1000 * Math.random());
		calc.operation(num);
		int k = calc.get();
		assertTrue("Check by positive number", k == num);
	}

	@Test(expected = ArithmeticException.class)
	public void testNegativeNumber() {
		int num = (int) (-1 - 1000 * Math.random());
		calc.operation(num);
		calc.get();
	}

	@After
	public void close() {
		calc.clear();
	}
}
