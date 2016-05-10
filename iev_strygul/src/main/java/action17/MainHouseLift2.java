package action17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHouseLift2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action17/config2.xml");
        House house = (House) context.getBean("house");
        System.out.println(house);
	}
}