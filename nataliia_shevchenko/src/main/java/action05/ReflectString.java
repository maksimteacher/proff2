package action05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Задача1: Вывести все методы класса String 
public class ReflectString {
	public static void main(String[] args) {
		String str = new String("qwerty");
		
		Class cl = str.getClass();
		Method [] met =  cl.getDeclaredMethods();
		
		for (Method method : met) {
			System.out.println(method);
		}
		
		Field [] fiel = cl.getDeclaredFields();
		for (Field field : fiel) {
			System.out.println(field);
		}
		
		//fiel[0].setAccessible(true);
		//String str1 = new String(fiel[0].get); 
	}
	

}
