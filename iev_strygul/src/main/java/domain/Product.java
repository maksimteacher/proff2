package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="product")

public class Product{
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="barcode")
	private int barcode;
	
	public Long getId() {
		return id;
	}
	
	public int getBarcode() {
		return barcode;
	}
	
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product() {
	}
	
	
	public Product(String name) {
		this.name = name;
	}
	
	public Product(String name, int code) {
		this.name = name;
		barcode = code;
	}

	@Override
	public String toString() {
		return "Product " + name;
	}
}

