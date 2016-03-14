package action04;
/*Задача 1. Написать программу:
Enum TypeProduct{Bread, Yogurt, Milk}
class Product{name, Enum type, int numberParty}
Main или ProductShop{Map<Product, String> shop(Product, NameOfContructor)}

Добавить в Карту по паре продуктов каждого типа.
Сделать:
1) Вывести список фирм в алфавитном порядке
2) Вывести список фирм в обратном порядке
3) Вывести уникальные наименования товаров по типу продуктов*/

public enum TypeProduct {
	Bread, Yogurt, Milk;
	public static void main(String[] args) {
		TypeProduct obj1 = TypeProduct.Milk;
		TypeProduct obj2 = TypeProduct.Bread;
		if(obj1==obj2)System.out.println("СЂР°РІРЅС‹");
		String str = obj1.toString();// "Milk"
		TypeProduct obj3 = TypeProduct.valueOf(str);
		TypeProduct[] arr = TypeProduct.values();
		TypeProduct obj4 = TypeProduct.values()[0];
		System.out.println(obj1.name());
	}
}
