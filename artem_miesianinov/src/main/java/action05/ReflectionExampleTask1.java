package action05;

import java.util.ArrayList;

public class ReflectionExampleTask1 {
	
	
	public String getHierarchy(Object obj) {
		String s = obj.getClass().getSuperclass().toString();
		return s;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> classHier = new ArrayList<>();
		Object obj = new ReflectionExample();
		Class clazz = obj.getClass();
		
	}
	
}
