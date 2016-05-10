package action17;

public class House {
	private String number;
	private Lift lift;
	
	public House() {
	}
	public House(String number) {
		this.number = number;
	}
	public static House getInstance(){
		return new House("default");
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
