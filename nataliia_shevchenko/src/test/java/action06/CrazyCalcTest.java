package action06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CrazyCalcTest {
	
	CrazyCalc calc;
	
	@Before
	public void init(){
		calc = new CrazyCalc();
	}

	@Test
	public void test0() {
		calc.clear();
		calc.operation(2);
		assertTrue(calc.get() == 2);
	}
	
	
	@Test(expected = Exception.class)
	public void test1() {
		calc.operation(-1);		
		calc.get();
	}
	
	@Test
	public void test2() {
		calc.clear();
		calc.operation(0);
		assertTrue(calc.get() == 0);
	}

}
