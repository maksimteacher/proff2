package tripleton;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClientTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Client.getInstance();
		Client.getInstance();
		
	}

	@Test
	public void test() {
		Client c1 = Client.getInstance();
		Client c2 = Client.getInstance();
		assertTrue(c1 == c2);
	}

}
