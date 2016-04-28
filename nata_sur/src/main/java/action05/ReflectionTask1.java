package action05;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.fabric.xmlrpc.base.Array;

//Рефлексия. Задача1: Вывести все методы класса String

public class ReflectionTask1 {
	public static void main(String[] args) {
		String obj = "fghjkl";
		Class cl = obj.getClass();
		Method[] m = cl.getMethods();
		//System.out.println(Arrays.toString(m));
		for (Method method : m) {
			//System.out.println(method);
		//System.out.println(method.getName());
			System.out.println(method.getName() + " " + method.getReturnType().getName());
		}

	}

}
