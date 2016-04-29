package action17;

public class Car {
	private String number;
	private Truck truck;
	private Human human;
	
	public Car(String number, Truck truck, Human human) {
		this.number = number;
		this.truck = truck;
		this.human = human;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Truck getTruck() {
		return truck;
	}
	public void setTruck(Truck truck) {
		this.truck = truck;
	}
	public Human getHuman() {
		return human;
	}
	public void setHuman(Human human) {
		this.human = human;
	}
}
