package action04;

public enum TypeProduct {
	Bread, Yogurt, Milk;
	public static void man(String[] args){
		TypeProduct obj1 = TypeProduct.Milk;
		TypeProduct obj2 = TypeProduct.Bread;
		if (obj1 == obj2) System.out.println("equals");
		//String str = obj1.toString();
		//TypeProduct obj3 = TypeProduct.valueOf(str);
		//TypeProduct[] arr = TypeProduct.values();
	}
}
