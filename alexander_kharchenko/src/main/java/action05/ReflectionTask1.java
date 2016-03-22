package action05;

import java.lang.reflect.Type;

public class ReflectionTask1 {

	public static void main(String[] args) {
		Integer i = 10;
		
		foo(i);
		System.out.println();
		Exception e = new ArrayIndexOutOfBoundsException();
		foo(e);
	}

	
	  static void foo(Object e) {
		foo(e, false);
		
	}


	static void foo(Object i, boolean flag) {
		Object o = new Object();
//		Class obCl = o.getClass();
		Class curCl = i.getClass();
		do {
			System.out.println("=> " + curCl + ":");
			if (flag) {
				for (Class intf : curCl.getInterfaces()) {
					System.out.println("     " + intf);
				}	
				System.out.println(curCl.toGenericString());
				for (Type gen : curCl.getGenericInterfaces()) {
					
					System.out.println("____" + gen);
				}
			}
			curCl = curCl.getSuperclass();
		} while (curCl != null);
		
	}

}
