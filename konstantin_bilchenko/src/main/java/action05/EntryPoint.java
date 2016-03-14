package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

class TestClassA {
};

class TestClassB extends TestClassA {
};

class TestClassC extends TestClassB {
};

class TestClassD extends TestClassC {
};

public class EntryPoint {

	public static List<String> ReflectionTask1Example(Object obj) {
		List<String> list = new LinkedList<>();
		Class objClass = obj.getClass();
		while (objClass != null) {
			list.add(0, objClass.getSimpleName());
			objClass = objClass.getSuperclass();
		}
		return list;
	}

	public static List<String> ReflectionTask2Example(Object obj) {
		List<String> list = new LinkedList<>();
		Class objClass = obj.getClass();
		while (objClass != null) {
			list.add(0, objClass.getSimpleName() + " >> " + Arrays.toString(objClass.getInterfaces()));
			objClass = objClass.getSuperclass();
		}
		return list;
	}

	public static void main(String[] args) {

/*		
		System.out.println("Task1");

		Class strClass = new String().getClass();
		Method[] strMethods = strClass.getDeclaredMethods();
		for (Method method : strMethods) {
			System.out.println(method.toString());
		}

		System.out.println("\nTask2");

		List<String> strList = ReflectionTask1Example(new TestClassD());
		for (String str : strList) {
			System.out.println(str);
		}

		System.out.println("\nTask3");
		strList = ReflectionTask2Example(new ArrayList());
		for (String str : strList) {
			System.out.println(str);
		}
*/
		
		Server s1 = Server.getInstance();
		Server s2 = Server.getInstance();

		if (s1 != s2) System.out.println("The same");
	

		
	}

}
