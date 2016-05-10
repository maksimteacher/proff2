package action18SpringAnnot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class House {
	
	private String number;
	
	@Autowired
	private Lift lift;

	public House() {
	}

	public House(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Lift getLift() {
		return lift;
	}

	public void setLift(Lift lift) {
		this.lift = lift;
	}

	@Override
	public String toString() {
		return "House [number=" + number + ", lift=" + lift + "]";
	}

}
