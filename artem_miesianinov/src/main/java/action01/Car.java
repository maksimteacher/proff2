package action01;


public class Car {

	//public static void main(String[] args) {
	private String number;
	private String color;
	private String marka;
//	car1.equals(car2);
	public boolean equals1(Car car) {
		
		  if(this == car) return true;
		  if(car == null) return false;
		  if(this.getClass() != car.getClass()) return false;
		  
		  boolean isNumberEquals = false;
		  if(this.number==null && car.number==null) isNumberEquals = true;
		  else if(this.number==null || car.number==null) return false;
		  else isNumberEquals = this.number.equals(car.number);
		return isNumberEquals;
		  
		  //return isNumberEquals && isNumberEquals
		 }

	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + ", marka=" + marka + "]";
	}
	
	public Car(String number, String color, String marka) {
		super();
		this.number = number;
		this.color = color;
		this.marka = marka;
	}
	
	public Car() {
		super();// TODO Auto-generated constructor stub
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}
}
