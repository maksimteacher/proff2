package action05;

public class ReflectionExampleTask2 {

	public static void main(String[] args) {
		Object obj = new ReflectionExampleTask2();
		Class[] arr = new Integer(4).getClass().getInterfaces();
		
		for (Class cl:arr) {
			System.out.println(cl.getName());
		}
	}

}
