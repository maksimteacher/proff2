package action05;

public class Car {
	private String color;
	private String number;
	private String marka;

	private Car() {
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

	public static Builder BuilderCar() {
		return new Car().new Builder();
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", number=" + number + ", marka=" + marka + "]";
	}

	public class Builder {

		private Builder() {
		}

		public Builder setColor(String color) {
			Car.this.color = color;
			return this;
		}

		public Builder setNumber(String number) {
			Car.this.number = number;
			return this;
		}

		public Builder setMarka(String marka) {
			Car.this.marka = marka;
			return this;
		}

		public Car build() {
			return Car.this;
		}

	}

}
