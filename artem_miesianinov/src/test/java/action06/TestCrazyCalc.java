package action06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestCrazyCalc {
	
	CrazyCalc crazyC1;

	@Before
	public void setUp() throws Exception {
		crazyC1 = new CrazyCalc();
	}
	
	@Test (expected = ArithmeticException.class)
	
	public void isPos() {
		
		int fact = crazyC1.get(); 
		assertEquals(expected, fact);
	}
}

