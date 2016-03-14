package hw_02.myarraylist;

import java.util.Iterator;
import java.util.function.Consumer;

public class Runner {

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "; ");
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		list.add(15);
		System.out.println(list);
		list.add(10);
		System.out.println(list);
		list.add(7);
		System.out.println(list);
		list.add(55);
		System.out.println(list);
		list.add(3);
		System.out.println(list);
		list.add(17);
		System.out.println(list);
		list.add(33);
		System.out.println(list);
		
		list.forEach1(c->System.out.println(c*10));
		
		list.forEach1(new Consumer<Integer>(){

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		});
		
		list.sort();
		System.out.println("ater sort:");
//		list.sort(new Comparator<Integer>(){
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o1 - o2;
//			}
//			
//		});
		System.out.println(list);
		System.out.println("list size is: " + list.size());
		System.out.println("the 3rd element is: " + list.get(3));
		list.add(0, 111);
		System.out.println(list);
		list.add(3, 333);
		System.out.println(list);
		list.add(10, 999);
		System.out.println(list);
		list.add(list.size(), 777);
		System.out.println(list);
		System.out.println(list.get(2));
		it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "; ");
		}
		
	}
	
	
}