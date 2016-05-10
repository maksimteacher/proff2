package action18SpringAnnot1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCar {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action18SpringAnnot1/config.xml");
		
		Car car = (Car) context.getBean("Car");
		System.out.println(car);
		car.setNumber("AA 111 AA");
		System.out.println(car);
	}
}
