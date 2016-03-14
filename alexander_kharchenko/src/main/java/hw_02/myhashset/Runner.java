package hw_02.myhashset;

import java.util.Random;

public class Runner {
	public static final int TO_DO = 15;
	public static final int RANGE = 7;
	
	public static void main(String[] args) {

		MyHashSet<Integer> set = new MyHashSet<>();
		Random r = new Random();
		for (int i = 0 ; i < TO_DO ; i++) {
			set.add(r.nextInt(RANGE));
		}
		System.out.println(set.size());
		for (int i = 0 ; i < RANGE ; i++) {
			System.out.println("contains(" + i + ")?=" + set.contains(i));
		}

		System.out.println("we're done.");
	}

}
