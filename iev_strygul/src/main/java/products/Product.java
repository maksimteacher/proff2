package products;

public class Product {
	private String name;
	private TypeProducts type;
	private int numberParty;
	
	public Product(String name, TypeProducts type, int numberParty) {
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
	public TypeProducts getType() {
		return type;
	}
	public void setType(TypeProducts type) {
		this.type = type;
	}
	public int getNumberParty() {
		return numberParty;
	}
	public void setNumberParty(int numberParty) {
		this.numberParty = numberParty;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
