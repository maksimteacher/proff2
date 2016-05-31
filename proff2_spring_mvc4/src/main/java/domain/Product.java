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
	@GeneratedValue(generator = "increment2")
	@GenericGenerator(name = "increment2", strategy = "increment")
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private int barcode = 0;

	public Long getId() {
		return id;
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

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", barcode=" + barcode + "]";
	}

	public String toPage() {
		return name + " " + barcode;
	}
	public Product() {
	}


	public Product(String name, int barcode) {
		this.name = name;
		this.barcode = barcode;
	}

	public Product(String name) {
		this(name,0);
	}
	
}
