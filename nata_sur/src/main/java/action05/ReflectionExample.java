package action05;

import java.lang.reflect.Field;

public class ReflectionExample {
	public int size;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Object obj = new ReflectionExample();
		Class clazz = obj.getClass();
		Field f = clazz.getField("size");
		System.out.println(f.getType());

		clazz.getMethods();
		clazz.getFields();
		clazz.getSuperclass();
		Class[] arr = new Integer(4).getClass().getInterfaces();
		for (Class cl : arr) {
			System.out.println(cl.getName());
		}

	}
}
