package homeworkArrayVSLinkedLists;
//This is from Internet and there is an error. This program should count time for execution of the ArrayList.

import java.util.*;

public class ListIterationTiming {
	
	private static final String[] CLASS_NAMES = new String[]{"java.util.LinkedList","java.util.ArrayList"};
	private static int dummy;// to avoid HotSpot(гор€ча€ точка) optimizing away iteration
	private final List<Integer> list;
	
	@SuppressWarnings("unchecked")
	private ListIterationTiming(String className, int size) throws Exception{
		list = (List<Integer>)Class.forName(className).newInstance();
		Random random = new Random(1);
		for (int i = 0; i < size; i++) list.add(random.nextInt());		
	}
			
	private double time(){
		int reps = 100000000 / list.size();
		long start = System.nanoTime();
		for (int rep = 0; rep < reps; rep++) dummy = dummy + runIteration();
		return (double)(System.nanoTime() - start)/reps/list.size(); 
	}
	
	private int runIteration(){
		//here I've got a bug, I make comment out this part of program and return 0 should be removed if I try to fix it.
//		int sum = 0;
//		for(Integer integer : list) 
//			sum = sum + integer;
//		return sum;
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		for (int pass = 1; pass <= 3; pass++) {
			System.out.printf("-----PASS %d ----- %n", pass);
			for (int size = 1000; size <= 1000000; size *= 10) {
				for (String className : CLASS_NAMES) {
					ListIterationTiming timing = new ListIterationTiming(className, size);
					System.out.printf(Locale.US, "%20s[%7d]: %.2f ns per item%n", className, size, timing.time());
				}
			}
			
		}
	}
}
