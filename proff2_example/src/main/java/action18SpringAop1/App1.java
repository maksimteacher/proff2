package action18SpringAop1;

import org.springframework.stereotype.Component;

@Component("app")
class App1 implements Perform{

	@Override
	public void perform() {
		System.out.println("App1.perform");
	}	
}
