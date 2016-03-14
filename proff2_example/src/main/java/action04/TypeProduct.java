package action04;

public enum TypeProduct {
	Bread, Yogurt, Milk;
	
	
	
	public static void main(String[] args) {
		TypeProduct obj1 = TypeProduct.Milk;
		TypeProduct obj2 = TypeProduct.Bread;
		if(obj1==obj2)System.out.println("равны");
		String str = obj1.toString();// "Milk"
		TypeProduct obj3 = TypeProduct.valueOf(str);
		TypeProduct[] arr = TypeProduct.values();
		TypeProduct obj4 = TypeProduct.values()[0];
		System.out.println(obj1.name());
	}
}
