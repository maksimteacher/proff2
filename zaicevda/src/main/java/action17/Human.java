package action17;

public class Human {
	@Override
	public String toString() {
		return "Human [name=" + name + "]";
	}

	private String name;
	
	public Human() {

	}

	public Human(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
