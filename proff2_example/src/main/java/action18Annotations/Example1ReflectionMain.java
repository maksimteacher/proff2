package action18Annotations;

public class Example1ReflectionMain {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//Class<?> cl = (new Example1Reflection()).getClass();
				
		Class<?> cl = Class.forName("action18Annotations.Example1Reflection");
		Example1Reflection obj = (Example1Reflection) cl.newInstance();
		obj.run();
	}
}
