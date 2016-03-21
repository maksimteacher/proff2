package Action6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import action4.Calc;
public class Calc1Test{
Calc1 calc1;
@Before
public void init(){
	calc1 = new Calc1();
	
}


@Test
public void test() {
	//int a = (int)(100*Math.random());
	//String mult = calc1.runOperation(5, (char) 5,"*");
	//assertEquals(25, mult);
	//fail("Not yet implemented");
	
	String sep = calc1.runOperation(4, (char) 2, "df");
	assertEquals(2, sep);
//	fail("Not yet implemented");
	
	String plus = calc1.runOperation(2, (char) 5,"df");
	assertEquals(7, plus);
	//fail("Not yet implemented");
	
	String min = calc1.runOperation(4, (char) 3,"df");
	assertEquals(1, min);
	//fail("Not yet implemented");
	
		}
@Test
public void test2(){
	
	
}
}