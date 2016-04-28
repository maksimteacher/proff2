package action17;

public class Track {
	@Override
	public String toString() {
		return "Track [number=" + number + "]";
	}

	private String number;

	public Track() {
		
	}

	public Track(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
