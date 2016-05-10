package action18Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Example3Annotation {
	public String parametr() default "";
	int value();// public
}

@Example3Annotation(10)
class MyClass1 {
}

@Example3Annotation(value = 20, parametr = "def")
class MyClass2 {
}

////////////////////////
@Target(ElementType.METHOD)
@interface MyAnnotation2ToMethod {
	public boolean OutPrint() default false;
}

class MyClass22 {
	@MyAnnotation2ToMethod(OutPrint = true)
	public void run() {
		System.out.println("run");
	}
}