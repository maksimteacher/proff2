package hw_02.myhashset;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class MyHashSetTest {
	static MyHashSet<Integer> mySet;
	static HashSet<Integer> set;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("123");
		mySet = new MyHashSet<>();
		set = new HashSet<>();
		
	}

	@Test
	public void test() {
		set.add(2);
		mySet.add(2);
		assertEquals(set.size(), mySet.size());
	}

	public void test2() {
		for (int i = 0 ; i < 10 ; i++) {
			int x = (int) (Math.random() * 100);
			set.add(x);
			mySet.add(x);
		}
		set.iterator();
	}
}
