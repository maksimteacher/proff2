package domain;

public class Product {
	private String name;
	private int barcode;

	public static String toTableHeader(){
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>");
		sb.append("<td>Имя</td>");
		sb.append("<td>Код</td>");
		sb.append("</tr>");
		return sb.toString();

	}
	public String toTable(){
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>");
		sb.append("<td>" + name + "</td>");
		sb.append("<td>" + barcode + "</td>");
		sb.append("</tr>");
		return sb.toString();
	}
	public Product(String name, int barcode) {
		this.name = name;
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}	
}
