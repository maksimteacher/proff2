package hw02.myhashmaptest;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import hw_02.myhashmap.MyHashMap;

public class MyHashMapTest {
	static Map<Integer, String> map;
	static MyHashMap<Integer, String> myMap;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		map = new HashMap<>();
		myMap = new MyHashMap<Integer, String>();

	}

	@Test
	public void test() {
		for (int i = 0 ; i < 100 ; i++) {
			map.clear();
			myMap.clear();
			stepTest();
		}
	}

	private void stepTest() {
		while (map.size() < 12) {
			Integer n = (int)(Math.random() * 100);
			String s = new String("s" + n);
			map.put(n, s);
			myMap.put(n, s);
		}
//		System.out.println(map.size() + " " + myMap.size());
				
		Iterator<Integer> it = myMap.iterator();
		int n = 0;
		for (Integer i : map.keySet()) {
//			System.out.print(n++ + ": " + i + " ");
			int next = it.next();
//			System.out.println(next);
//			assertTrue(i.equals(it.next()));
			assertTrue((i - next) == 0);
		}
	}
}
