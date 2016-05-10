package action18SpringAop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action18SpringAop1/config.xml");
		//App1 app = (App1)context.getBean("app"); Error
		Perform app = (Perform)context.getBean("app");// normal
		app.perform();
	}
}
