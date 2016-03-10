package action01;

public class Car {
	private String number;
	private String color;
	private String marka;
	//  car1.equals(c2)
	
	public Boolean equals1(Car car){
		if(this == car) return true;
		if(car == null) return false;
		if(this.getClass() != car.getClass()) return false;
		
		boolean isNumberEquals = false;
		if(this.number==null && car.number==null) isNumberEquals = true;
		else if(this.number==null || car.number==null) return false;
		else isNumberEquals = this.number.equals(car.number);
		
		//return isNumberEquals && isNumberEquals
		return null;
	}
	 

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		
		if (marka == null) {
			if (other.marka != null)
				return false;
		} else if (!marka.equals(other.marka))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}






	@Override
	public String toString() {
		return "Car [number=" + number + ", color=" + color + ", marka=" + marka + "]";
	}
	public Car() {
		super();
	}
	public Car(String number, String color, String marka) {
		super();
		this.number = number;
		this.color = color;
		this.marka = marka;
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
