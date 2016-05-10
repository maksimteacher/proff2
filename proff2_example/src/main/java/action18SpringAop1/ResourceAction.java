package action18SpringAop1;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResourceAction {
	@Pointcut("execution(* action18SpringAop1.Perform.perform(..))")
	public void perfomance(){
		System.out.println("ppp");
	}
	
	@Before("perfomance()")
	public void open(){
		System.out.println("Before: open resource");
	}
	@After("perfomance()")
	public void close(){
		System.out.println("After: close resource");
	}	
}
