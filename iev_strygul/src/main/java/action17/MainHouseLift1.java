package action17;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHouseLift1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("action17/config1.xml");
		
		Lift lift = (Lift) context.getBean("idLift");//СѓРєР°Р·С‹РІР°РµРј id РЅР°С€РµРіРѕ bean-Р°
        System.out.println(lift);
        
        House house = (House) context.getBean("idHouse");
        System.out.println(house);
	}
}
