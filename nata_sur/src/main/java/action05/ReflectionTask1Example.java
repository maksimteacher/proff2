package action05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Задача2:(ReflectionTask1Example) Написать метод принимающий любой объект.
Метод возвращает все классы в иерархию которых входит данный объект. */

public class ReflectionTask1Example {
	public static void main(String[] args) {
	//	Class[] classes = method(new ArrayList());
		Class[] classes = method(new Integer (4));
		System.out.println(Arrays.toString(classes));
	}

	public static Class[] method (Object obj) {
		List<Class> cl = new ArrayList<Class>();
		cl.add(obj.getClass());
		for (int i = 0; i < cl.size(); i++) {
			Class superCl = cl.get(i).getSuperclass();
			if (superCl != null){
				cl.add(superCl);
			}
		}
		return cl.toArray(new Class[0]);
	}
}
