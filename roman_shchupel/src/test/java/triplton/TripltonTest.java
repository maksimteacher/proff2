package triplton;

import static org.junit.Assert.*;

import org.junit.Test;

public class TripltonTest {
	

	@Test
	public void test() {
		
		Triplton trip1 = Triplton.GetInstance();
		Triplton trip2 = Triplton.GetInstance();
		Triplton trip3 = Triplton.GetInstance();
		Triplton trip4 = Triplton.GetInstance();
		
		assertTrue((trip1 != trip2) && (trip1 != trip3) && (trip2 != trip3) && (trip4 == trip3));

	}

}
