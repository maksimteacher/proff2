package Action12.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import resourses.Product;

public class ProductViewer {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty code;

    public ProductViewer(int id, String name, String code) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleStringProperty(code);
    }

    public ProductViewer(Product product) {
        this(product.getId(), product.getName(), product.getBarcode());
    }

    public Product toProduct() {
        Product product = new Product(getName(), getCode());
        product.setId(getId());
        return product;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }
}
