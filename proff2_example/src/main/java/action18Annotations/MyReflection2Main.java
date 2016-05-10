package action18Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class MyReflection2Main {
	private static List<Object> services = Arrays
			.asList(new Object[] { new ServerService(), new ClientService(), new ClientService() });

	public static void main(String[] args) {
		services.forEach(s -> startService(s));
	}

	public static void startService(Object obj) {
		try {
			Method[] methods = obj.getClass().getMethods();
			Object[] argsEmpty = new Object[] {};
			for (Method method : methods) {
				if (method.isAnnotationPresent(Start.class)) {
					method.invoke(obj, argsEmpty);
				}
			}
		} catch (Exception e) {
			System.out.println("error");
		}
	}
}


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Start {
}

class ServerService {
	@Start
	public void init() {
		System.out.println("start Server Service");
	}

	@Override
	public String toString() {
		return "ServerService";
	}
}

class ClientService {
	private static int count = 0;
	private int number = 0;

	public ClientService() {
		number = ++count;
	}

	@Start
	public void goGo() {
		System.out.println("start Client Service");
	}

	@Override
	public String toString() {
		return "ClientService";
	}
}
