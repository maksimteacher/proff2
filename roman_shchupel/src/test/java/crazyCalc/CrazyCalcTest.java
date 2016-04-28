package crazyCalc;

import static org.junit.Assert.*;

/*
CrazyCalc.
operation: setValue
get : if(value>=0) return value; else throws new ArithmeticException();
clear: setValue( 0 ) 
*/

import org.junit.Before;
import org.junit.Test;

public class CrazyCalcTest {
	CrazyCalc calc;

	@Before
	public void  init() throws Exception {
		calc = new CrazyCalc();
	}
	
	
	@Test(expected = ArithmeticException.class)
	public void test0() {
		//int a = (int)(1000*Math.random());
		calc.operation(-1);
		int res = calc.get();
		
	}
	
	@Test//(expected = NullPointerException.class)
	public void test1() {
		//int a = (int)(1000*Math.random());
		calc.operation(0);
		int res = calc.get();
		//if(res!=0) fail("Not by zero");
		//assertTrue("Error by zero",res==0);
		//assertTrue(res==0);		
	}
	
	@Test
	public void test3() {
		//int a = (int)(1000*Math.random());
		calc.operation(100);
		int res = calc.get();
		//if(res!=0) fail("Not by zero");
		//assertTrue("Error by zero",res==0);
		assertTrue(res==100);		
	}
	
	@Test
	public void test4() {
		//int a = (int)(1000*Math.random());
		calc.operation(0);
		int res = calc.get();
		//if(res!=0) fail("Not by zero");
		//assertTrue("Error by zero",res==0);
		assertTrue(res==0);		
	}
	
}
