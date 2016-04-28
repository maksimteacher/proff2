package action04;

public class Product {
	
	private String name;
	private TypeProduct type;
	private int numberParty;
	
	public Product(String name, TypeProduct type, int numberParty) {
		super();
		this.name = name;
		this.type = type;
		this.numberParty = numberParty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeProduct getType() {
		return type;
	}

	public void setType(TypeProduct type) {
		this.type = type;
	}

	public int getNumberParty() {
		return numberParty;
	}

	public void setNumberParty(int numberParty) {
		this.numberParty = numberParty;
	}
	
	
	

}
