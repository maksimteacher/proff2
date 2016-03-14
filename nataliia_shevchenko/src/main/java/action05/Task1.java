package action05;

public class Task1 {
	public static void main(String[] args) {
		Integer in = 10;
		method(in);

	}

	public static void method(Object obj) {

		Object o = new Object();
		Class sec = obj.getClass();
		while (sec != null) {
			System.out.println("!!" + sec);
			for (Class c : sec.getInterfaces()) {
				System.out.println("-->" + c);				
			}
			
			sec = sec.getSuperclass();
		}

	}
}