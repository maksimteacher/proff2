package action05;

public class CarBuilderExample {
	public static void main(String[] args) {
		Car car = new BuilderCar().setColor("Black")
				.setNumber("AA 111").build();
		System.out.println(car);
	}	
}
class BuilderCar{
	private String number;
	private String color;	
	private String marka;
	
	public Car build(){
		return new Car(this);
	}
	public BuilderCar setMarka(String marka){
		this.marka=marka;
		return this;
	}
	
	public BuilderCar setColor(String color){
		this.color=color;
		return this;
	}
	public BuilderCar setNumber(String number){
		this.number=number;
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
	
	
}
class Car{
	private String number;
	private String color;	
	private String marka;
	public Car(BuilderCar builder){
		this.color = builder.getColor();
		this.number = builder.getNumber();
		this.marka = builder.getMarka();
	}
	
	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + ", marka=" + marka + "]";
	}

	public String getColor() {
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
	}
	
}
