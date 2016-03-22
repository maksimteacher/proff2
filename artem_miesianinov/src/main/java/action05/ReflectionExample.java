package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectionExample {

	public int size;
	public static void main(String[] args) throws NoSuchFieldException
	{
		Object obj = new ReflectionExample();
		Class clazz = obj.getClass();
	/*	Field f = clazz.getField("size");
		System.out.println(f.getType());*/
		
		//task1
	/*	String stringExample = "";    //equal to  = new String();
		Class str = stringExample.getClass();
		Method[] stringMethods = str.getDeclaredMethods();
		for (Method method : stringMethods) {
			System.out.println(method.toString());
		}
	 */
		//task2		
		
		
	}
	
	
	
}
