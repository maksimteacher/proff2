package homeworkArrayVSLinkedLists;

import java.util.Date;



/*1. ArrayList vs LinkedList
Вставка случайных чисел от 1 до 10000.
 - insert by index 0
 - insert by index size()/2
 - insert by index size()-1
10000 элементов
какая разница в скорости ArrayList, если в конструкторе задавать capacity 10000 или не задавать.
кто быстрее и насколько при подсчете суммы чисел из ArrayList vs LinkedList.

  long time1 = System.nanoTime();
   //
  long time2 = System.nanoTime();
  long score = time2 - time1;*/

public class Main {
	public static void main(String[] args) {
		int size = 10000;
		ArrayList<Integer> list = new ArrayList<>();
		Date startArray = new Date();
		for (int i = 0; i < size; i++) {
			list.add(i);			
		}
		Date finishArray = new Date();
		long arrayTime = finishArray.getTime() - startArray.getTime();
		System.out.println("Insert ArrayList: " + arrayTime);
		//System.out.println(list);
		
		LinkedList<Integer> list1 = new LinkedList<>();
		Date startLinked = new Date();
		for (int i = 0; i < size; i++) {
			list1.add(i + 10);
		}
		Date finishLinked = new Date();
		long LinkedTime = finishLinked.getTime() - startLinked.getTime();
		System.out.println("Insert LinkedList: " + LinkedTime);
		//System.out.println(list1);
		System.out.println("**********************************");
		
		
		long time1 = System.nanoTime();
		list.add(0, 36);		
		long time2 = System.nanoTime();
		long score = time2 - time1;		
		System.out.println("Insert ArrayList (index=0): " + score);
		//System.out.println(list);
		long time3 = System.nanoTime();
		list1.add(0, 36);		
		long time4 = System.nanoTime();
		long score2 = time4 - time3;		
		System.out.println("Insert LinkedList (index=0): " + score2);
		//System.out.println(list1);
		System.out.println("**********************************");
		
		long time5 = System.nanoTime();		
		list.add(size-1, 29);			
		long time6= System.nanoTime();
		long score3 = time6 - time5;
		System.out.println("Insert ArrayList (index=size-1): " + score3);
		//System.out.println(list);
		long time7 = System.nanoTime();		
		list1.add(size-1, 29);			
		long time8= System.nanoTime();
		long score4 = time8 - time7;		
		System.out.println("Insert LinkedList (index=size-1): " + score4);
		//System.out.println(list1);
		System.out.println("**********************************");
		
		long time9 = System.nanoTime();
		list.add(size/2, 23);			
		long time10 = System.nanoTime();
		long score5 = time10 - time9;		
		System.out.println("Insert ArrayList (index=size/2): " + score5);
		//System.out.println(list);
		long time11 = System.nanoTime();
		list1.add(size/2, 23);			
		long time12 = System.nanoTime();
		long score6 = time12- time11;		
		System.out.println("Insert LinkedList (index=size/2): " + score6);
		//System.out.println(list1);
		System.out.println("**********************************");
		
		
//		Date startLinked = new Date();
//		for (int i = 0; i < size; i++) {
//			list1.add(i + 10);
//		}
//		Date finishLinked = new Date();
//		long LinkedTime = finishLinked.getTime() - startLinked.getTime();
//		System.out.println("Insert LinkedList: " + LinkedTime);
		
//		
//		long time1 = System.nanoTime();
//		  
//		long time2 = System.nanoTime();
//		long score = time2 - time1;
//		list.add(4, null);
		//System.out.println(list);
		//System.out.println(list1);
		//System.out.println(arrayTime);
	}

}
