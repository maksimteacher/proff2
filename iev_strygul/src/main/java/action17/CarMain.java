package action17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configCar.xml");
		
		Car car = (Car) context.getBean("idCar");
	    System.out.println(car.getNumber());
	}
}
