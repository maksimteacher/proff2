package hw_02.myhashmap;

import java.util.Iterator;
import java.util.Random;

public class Runner {
	public static final int TO_DO = 15;
	public static final int RANGE = 25;
	
	public static void main(String[] args) {
	
		MyHashMap<Integer, String> map = new MyHashMap<>();
		Random r = new Random();
		for (int i = 0 ; i < TO_DO ; i++) {
			int n = r.nextInt(RANGE);
			int m = r.nextInt(RANGE);
			map.put(n, "_" + m);
		}
		System.out.println(map.size());
		for (int i = 0 ; i < RANGE ; i++) {
			System.out.println("contains(" + i + ")?=" + map.contains(i));
		}

		System.out.println("we're done.");
		
		Iterator<Integer> i = map.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
