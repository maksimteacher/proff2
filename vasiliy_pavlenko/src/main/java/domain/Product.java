package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name="id")
	private Integer id;
	
	public Product(String name, String barcode) {
		super();
		this.name = name;
		this.barcode = barcode;
	}


	@Column(name="name")
	private String name;
	
	@Column(name="barcode")
	private String barcode;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}


	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	public Product() {
		super();
	}


	@Override
	public String toString() {
		return "Product " + name;
	}
}

