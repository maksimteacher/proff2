package Action5;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflection {

	private static final String Arraylis = null;
	public static void main(String[] args) {
	//Рефлексия. Задача1: Вывести все методы класса String
		String s = "dd";
		Class cl = s.getClass();
		
		Method[] arr = cl.getDeclaredMethods();
		for(Method i: arr){
				System.out.println(i.getName());
		}
		System.out.println();
		printClass(new Integer(8));
		
				
	}
		//Задача2:(ReflectionTask1Example) Написать метод принимающий любой объект.
	 //Метод возвращает все классы в иерархию которых входит данный объект. 
	/*
	public Class [] Task(Object obj){
		
		
	obj.getClass();
	return ;
	
		
	}
	*/
	public static void printClass(Object obj){
		Class clazz = obj.getClass();
		
		ArrayList<Class> list = new ArrayList<Class>();
		list.add(clazz);
		
		while(clazz.getSuperclass()!=null) {
			
			list.add(clazz.getSuperclass());
			clazz = clazz.getSuperclass();
		}
		for(Class s: list)
		System.out.println(s.getName());
	}
	
	//Задача3:(ReflectionTask2Example) Написать метод, принимающий любой объект, 
	//выводящий список всех интерфейсов по иерархии наследования классов.
	
	public static void Inter(Object obj){
		
		//Object inter = obj.getInterfaces();
		
	}
}
