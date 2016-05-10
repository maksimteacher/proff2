package action18Annotations;

public @interface Example2Annotation {
}

@Example2Annotation
class MyClass{
	@Example2Annotation
	public void m(){		
	}
}
