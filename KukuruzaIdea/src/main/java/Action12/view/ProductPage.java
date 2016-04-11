package Action12.view;

import Action12.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import resourses.Product;

import java.util.List;

public class ProductPage implements TemplatePage {
    private ObservableList<ProductViewer> products = FXCollections.observableArrayList();
    private TableView<ProductViewer> table = new TableView<>();
    private ProductService servisProduct = null;
    private GridPane panel = new GridPane();

    public ProductPage(ProductService servisProduct) {
        this.servisProduct = servisProduct;
        init();
    }

    private void init() {
        // From DataBase To ObservableList
        List<Product> list = servisProduct.getAllProducts();
        for (Product prod : list) {
            products.add(new ProductViewer(prod));
        }
        Label label = new Label("Catalog Products");
        label.setLayoutX(140);
        label.setLayoutY(20);
        label.setStyle("-fx-font-size:20px");

        initTable();
        table.setLayoutX(120);
        table.setLayoutY(60);
        table.setStyle("-fx-font-size:16px");

        GridPane control = new ControlPanel(this, 2).getPanel();
        control.setLayoutX(120);
        control.setLayoutY(300);

        panel.setAlignment(Pos.CENTER);
        panel.add(label, 0, 0);
        panel.add(table, 0, 1);
        panel.add(control, 0, 2);
    }

    private void initTable() {
        table.setEditable(true);

        TableColumn<ProductViewer, Integer> firstNameCol = new TableColumn<>("id");
        TableColumn<ProductViewer, String> secondNameCol = new TableColumn<>("name");
        TableColumn<ProductViewer, String> thirdNameCol = new TableColumn<>("code");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        secondNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        thirdNameCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        table.setItems(products);

         table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
//        table.getColumns().add(firstNameCol);
//        table.getColumns().add(secondNameCol);
//        table.getColumns().add(thirdNameCol);

        // Editable Name
        secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        secondNameCol.setOnEditCommit(value -> {
            String str = value.getNewValue();
            int activeRow = value.getTablePosition().getRow();
            ProductViewer productViewer = value.getTableView().getItems().get(activeRow);
            productViewer.setName(str);

            // update product by DataBase
            servisProduct.updateProduct(productViewer.toProduct());
        });
        // Editable Code
        thirdNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        thirdNameCol.setOnEditCommit(value -> {
            String val = value.getNewValue();
            int activeRow = value.getTablePosition().getRow();
            value.getTableView().getItems().get(activeRow).setCode(val);
        });
    }

    public GridPane getGridPane() {
        return panel;
    }

    @Override
    public void remove() {
        int index = table.editingCellProperty().get().getRow();
        Product product = products.get(index).toProduct();
        products.remove(index);
        servisProduct.deleteProduct(product);
    }

    @Override
    public void add(TextField[] arr) {

    }

    @Override
    public void help() {
        // TODO Auto-generated method stub

    }
}
