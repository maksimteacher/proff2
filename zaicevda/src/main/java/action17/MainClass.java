package action17;

import org.springframework.context.ApplicationContext;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action17/conf.xml");
		Car car = (Car) context.getBean("idCar");
		Human human = (Human) context.getBean("idHuman");
		Track track = (Track) context.getBean("idTrack");
		System.out.println(car.toString());
	}
}
