package singleton;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import singlton.Server;

public class ServerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		Server s1 = Server.getInstance();
		Server s2 = Server.getInstance();
		assertTrue(s1 == s2);
	}

}
