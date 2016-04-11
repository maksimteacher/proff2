package action04;
/*Задача 1. Написать программу:
Enum TypeProduct{Bread, Yogurt, Milk}
class Product{name, Enum type, int numberParty}
Main или ProductShop{Map<Product, String> shop(Product, NameOfContructor)} //тут написано название карты

Добавить в Карту по паре продуктов каждого типа.
Сделать:
1) Вывести список фирм в алфавитном порядке
2) Вывести список фирм в обратном порядке
3) Вывести уникальные наименования товаров по типу продуктов*/
public class Product {
	private String name;
	private TypeProduct type;
	private int numberParty;
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
	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", numberParty=" + numberParty + "]";
	}
	public Product(String name, TypeProduct type, int numberParty) {
		super();
		this.name = name;
		this.type = type;
		this.numberParty = numberParty;
	}
	
	
	

}
