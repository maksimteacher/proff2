package Action12.view;

import Action12.service.ContructorService;
import Action12.service.ContructorService;
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
import resourses.Contructor;
import resourses.Contructor;

import java.util.List;

public class ContructorPage implements TemplatePage {
    private ObservableList<ContructorViewer> contructor = FXCollections.observableArrayList();
    private TableView<ContructorViewer> table = new TableView<>();
    private ContructorService servisContructor = null;
    private GridPane panel = new GridPane();

    public ContructorPage(ContructorService servisContructor) {
        this.servisContructor = servisContructor;
        init();
    }

    private void init() {
        // From DataBase To ObservableList
        List<Contructor> list = servisContructor.getAllContructors();
        for (Contructor prod : list) {
            contructor.add(new ContructorViewer(prod));
        }

        Label label = new Label("Catalog Contructors");
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

        TableColumn<ContructorViewer, Integer> firstNameCol = new TableColumn<>("id");
        TableColumn<ContructorViewer, String> secondNameCol = new TableColumn<>("name");
        TableColumn<ContructorViewer, String> thirdNameCol = new TableColumn<>("code");

        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        secondNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        thirdNameCol.setCellValueFactory(new PropertyValueFactory<>("code"));

        table.setItems(contructor);

        // table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
        table.getColumns().add(firstNameCol);
        table.getColumns().add(secondNameCol);
        table.getColumns().add(thirdNameCol);

        // Editable Name
        secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        secondNameCol.setOnEditCommit(value -> {
            String str = value.getNewValue();
            int activeRow = value.getTablePosition().getRow();
            ContructorViewer productViewer = value.getTableView().getItems().get(activeRow);
            productViewer.setName(str);

            // update product by DataBase
           // servisContructor.updateContructor(productViewer.toContructor());
        });
        // Editable Code
//        thirdNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
//        thirdNameCol.setOnEditCommit(value -> {
//            String val = value.getNewValue();
//            int activeRow = value.getTablePosition().getRow();
//            value.getTableView().getItems().get(activeRow).setCode(val);
//        });
    }

    public GridPane getGridPane() {
        return panel;
    }

    @Override
    public void remove() {
        int index = table.editingCellProperty().get().getRow();
        Contructor product = contructor.get(index).toContructor();
        contructor.remove(index);
        //servisContructor.deleteContructor(product);
    }

    @Override
    public void add(TextField[] arr) {

    }

    @Override
    public void help() {
        // TODO Auto-generated method stub

    }
}
