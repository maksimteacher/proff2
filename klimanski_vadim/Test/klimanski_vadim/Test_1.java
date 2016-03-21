package klimanski_vadim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import action4.Calc;

public class Test_1 {
	
	Calc calc;
	@Before
	public void init(){
		calc = new Calc();
		
	}
	

	@Test
	public void test() {
		//int a = (int)(100*Math.random());
		int mult = calc.metodCalc(5, "*",5);
		assertEquals(25, mult);
		//fail("Not yet implemented");
		
		int sep = calc.metodCalc(4, "/", 2);
		assertEquals(2, sep);
	//	fail("Not yet implemented");
		
		int plus = calc.metodCalc(2, "+", 2);
		assertEquals(4, plus);
		//fail("Not yet implemented");
		
		int min = calc.metodCalc(4, "-", 2);
		assertEquals(2, min);
		//fail("Not yet implemented");
		
			}
	@Test
	public void test2(){
		
		
	}

}
