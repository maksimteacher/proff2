package Action11.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    @Id
    private Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "barcode")
    String barcode;

    public Integer getId() {
        return id;
    }

    public Product() {
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Product(String name, String barcode) {

        this.name = name;
        this.barcode = barcode;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
