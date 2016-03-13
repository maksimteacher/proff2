package action05;

public class BuilderCar {
	private String number;
	private String color;
	private String marka;
	
	public static class BuilderCar {
	
		public setNumber (String number) {
			this.number = number;
			return this;
		}
		
		public setColor (String number) {
			this.color = color;
			return this;
		}
		
		public setMarka (String number) {
			this.marka = marka;
			return this;
		}
		
		public Car build() {
			return new  Car(this);
		}
	}
	
	public static void main(String[] args) {
		Car car1 = new BuilderCar().setNumber("AA 1111").build();
		Car car2 = new BuilderCar().setNumber("BB 2222").setColor("Red").build();
		Car car3 = new BuilderCar().setNumber("CC 33333").setMarka("BMW").setColor("Red").build();// TODO Auto-generated method stub

	}

}
