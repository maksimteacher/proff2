package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
			list.add(0, "'" + objClass.getSimpleName() + "'" 
					+ " >> Interfaces: " + Arrays.toString(objClass.getInterfaces()));
			objClass = objClass.getSuperclass();
		}
		return list;
	}

	public static void main(String[] args) {

		// task1
		/*
		 * Class strClass = new String().getClass(); Method[] strMethods =
		 * strClass.getDeclaredMethods(); for (Method method : strMethods) {
		 * System.out.println(method.toString()); }
		 */

		// task2
		/*
		 * List<String> strList = ReflectionTask1Example(new TestClassD()); for
		 * (String str : strList) { System.out.println(str); }
		 */

		// task3
		List<String> strList = ReflectionTask2Example(new ArrayList());
		for (String str : strList) {
			System.out.println(str);
		}

	}

}
