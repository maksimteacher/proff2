package action04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMiniCalk {
	MiniCalk calc;

	@Before
	public void init() {
		calc = new MiniCalk();
	}

	@Test
	public void test0() {
		int a = (int) (1000 * Math.random());
		int res = calc.multiply(a, 0);
		//if(res!=0) fail("Not by zero");
		//assertTrue("Error by zero",res==0);
		assertTrue(res==0);		
	}

	@Test
	public void test1() {
		int a = (int) (1000 * Math.random());
		int res = calc.multiply(a, 1);
		//if(res!=0) fail("Not by zero");
		//assertTrue("Error by one", res == a);
				assertTrue(res==a);	
	}
}
