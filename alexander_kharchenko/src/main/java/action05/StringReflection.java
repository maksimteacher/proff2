package action05;

import java.lang.reflect.Method;
import java.util.Arrays;

public class StringReflection {

	public static void main(String[] args) {
		String s = new String("abc");
		
		Class cl = s.getClass();
		Method[] m = cl.getDeclaredMethods();

		for (Method method : m) {
			System.out.println(method);
		}
		
		

	}

}
