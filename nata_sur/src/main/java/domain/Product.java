package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	public Product(){
		
	}
	
	public Product(String name, int barcode) {
		this.name = name;
		this.barcode = barcode;
	}

	public Product(int id, String name, int barcode) {
		this.id = id;
		this.name = name;
		this.barcode = barcode;
	}
	
	@Column(name="barcode")
	private int barcode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", barcode=" + barcode + "]";
	}
	
	
}
