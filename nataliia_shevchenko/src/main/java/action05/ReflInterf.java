package action05;

import javassist.tools.reflect.Reflection;

/*Задача3:(ReflectionTask2Example) Написать метод, 
 * принимающий любой объект, выводящий список всех интерфейсов по иерархии наследования классов.*/

public class ReflInterf {
	public static void main(String[] args) {
		Object obj = new Reflection();
		Class clazz = obj.getClass();
		
		//Class[] arr = clazz.getInterfaces();
		Class[] arr = new Integer(4).getClass().getInterfaces();
		for(Class cl: arr){
			System.out.println(cl.getName());
		}
		
	}
	
//	public Class[] method (Object obj){//так если метод будет возвращать методы класса
//		Object o = new  Object();
//		Class sec = obj.getClass();
//		while (sec != null){
//			System.out.println(sec);
//			sec = sec.getSuperclass();			
//		}
//		return null;
//	}
}



class Aa implements Runnable {
	
	@Override
	public void run() {
		
	}
}