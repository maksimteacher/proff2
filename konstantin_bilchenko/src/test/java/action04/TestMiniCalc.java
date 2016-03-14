package action04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import action04.MiniCalc;

public class TestMiniCalc {

	MiniCalc calc;

	@Before
	public void init() {
		calc = new MiniCalc();
	}

	@Test
	public void test0() {
		int a = (int) (Math.random() * 1000);
		int res = calc.multiply(a, 0);
		assertTrue(res == 0);
	}
	
	@Test
	public void test1() {
		int a = (int) (Math.random() * 1000);
		int res = calc.multiply(a, 1);
			assertTrue(res == a);
	}

}
