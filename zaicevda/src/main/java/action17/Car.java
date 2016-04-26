package action17;

public class Car {
	@Override
	public String toString() {
		return "Car [number=" + number + ", track=" + track + ", human=" + human + "]";
	}

	private String number;
	private Track track;
	private Human human;

	public Car() {

	}
	
	public Car(String number){
		this.number = number;
	}
	
	public Car(String number, Track track){
		this.number = number;
		this.track = track;
	}
	
	public Car(String number, Track track, Human human){
		this.number = number;
		this.track = track;
		this.human = human;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}
}
