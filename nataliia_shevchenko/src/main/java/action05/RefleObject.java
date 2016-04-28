package action05;
/*Задание 2 Написать метод принимающий любой объект.
Метод возвращает все классы в иерархию которых входит данный объект. */
public class RefleObject {
	public static void main(String[] args) {
		Integer in = 10;
		method(in);
		
		
	}
	
	public static void method (Object obj){ //так если метод вываодит на экран значения
	//public Class[] method (Object obj){//так если метод будет возвращать методы класса
		Object o = new  Object();
		Class sec = obj.getClass();
		while (sec != null){
			System.out.println(sec);
			sec = sec.getSuperclass();			
		}
//		Class one = o.getClass();
//		Class sec = obj.getClass();
//		while (sec != one){
//			System.out.println(sec);
//			sec = sec.getSuperclass();			
//		}
	}

}
