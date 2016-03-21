package Action6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CrazyCalcTest {

	CrazyCalc calc;

	@Before
	public void init() {
		calc = new CrazyCalc();
	}

	@Test(expected = ArithmeticException.class)
	public void test1() {
		calc.operation(-2);
		@SuppressWarnings("unused")
		int num = calc.get();
		calc.get();
		//assertTrue(num == -2);

	}
	@Test
	public void test2() {
		calc.operation(10);
		int num = calc.get();

		assertTrue(num == 10);

}
	@Test
	public void test3() {
		calc.operation(0);
		int num = calc.get();

		assertTrue(num == 0);
}
}