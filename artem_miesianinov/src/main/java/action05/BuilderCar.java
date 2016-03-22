package action05;

class BuilderCar {

	private String number;
	private String color;
	private String marka;
	
	public static void main(String[] args) {
		Car car1 = new BuilderCar().setNumber("AA 1111").build();
		Car car2 = new BuilderCar().setNumber("BB 2222").setColor("Red").build();
		Car car3 = new BuilderCar().setNumber("CC 33333").setMarka("BMW").setColor("Red").build();
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
	}
	
	
	public Car build() {
		return new Car(this);
	}
	
	public BuilderCar setMarka (String marka) {
		this.marka = marka;
		return this;
	}
	
	public BuilderCar setNumber (String number) {
		this.number = number;
		return this;
	}
	
	public BuilderCar setColor(String color) {
		this.color = color;
		return this;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getMarka() {
		return marka;
	}

class Car{
	private String number;
	private String color;
	private String marka;
	
	public Car (BuilderCar builder) {
		this.color = builder.getColor();
		this.number = builder.getNumber();
		this.marka = builder.getMarka();
	}
	
	@Override
	
	public String toString() {
		return "Car [number=" + number + ", color=" + color + ", marka=" + marka + "]";
	}
	
	/*public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getMarka() {
		return marka;
	}
	
	public void setMarka(String marka) {
		this.marka = marka;
	}*/
}
}


