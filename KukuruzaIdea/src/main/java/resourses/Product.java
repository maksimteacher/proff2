package resourses;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", unique = true, nullable = false)

    private Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "barcode")
    String barcode;

    @Id
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", barcode='" + barcode + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
