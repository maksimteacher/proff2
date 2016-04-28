package view;

import java.util.List;

import domain.Contructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import service.ContructorService;

public class ContructorPage implements TemplatePage{
	private ObservableList<ContructorViewer> contructors = FXCollections.observableArrayList();
	private TableView<ContructorViewer> table = new TableView<ContructorViewer>();
	private ContructorService serviceContructor = null;
	private GridPane panel = new GridPane();
	
	public ContructorPage(ContructorService serviceContructor){
		this.serviceContructor = serviceContructor;
		init();
	}
	private void init(){
		// From DataBase To ObservableList
		List<Contructor> list = serviceContructor.getAllContructors();
		for(Contructor contr:list) {
			contructors.add(new ContructorViewer(contr));
		}

		Label label = new Label("Catalog Contructors");
		label.setLayoutX(140);
		label.setLayoutY(20);
		label.setStyle("-fx-font-size:20px");
				
		initTable();
		table.setLayoutX(120);
		table.setLayoutY(60);
		table.setStyle("-fx-font-size:16px");
		
		GridPane control = new ControlPanel(this,2).getPanel();
		control.setLayoutX(120);
		control.setLayoutY(300);
		
		panel.setAlignment(Pos.CENTER);
		panel.add(label,0,0);
		panel.add(table,0,1);
		panel.add(control,0,2);
	}	
	private void initTable(){	
		table.setEditable(true);

		TableColumn<ContructorViewer, Integer> firstNameCol = new TableColumn<ContructorViewer, Integer>("id");
		TableColumn<ContructorViewer, String> secondNameCol = new TableColumn<ContructorViewer, String>("name");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<ContructorViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<ContructorViewer, String>("name"));

		table.setItems(contructors);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);
		
		// Editable Name
		secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<ContructorViewer, String>>() {
			@Override
			public void handle(CellEditEvent<ContructorViewer, String> value) {
				String str = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				ContructorViewer contructorViewer = value.getTableView().getItems().get(activeRow);
				contructorViewer.setName(str);
				
				// update product by DataBase
				serviceContructor.updateContructor(contructorViewer.toContructor());
			}
		});
		

	}	

	public  GridPane getGridPane(){
		return panel;
	}
	
	@Override
	public void remove() {
		int index = table.editingCellProperty().get().getRow();
		Contructor contructor = contructors.get(index).toContructor(); 
		contructors.remove(index);
		serviceContructor.deleteContructor(contructor);
	}
	@Override
	public void add(TextField[] arr) {
		String name = "";
		int code = 0;
		try{
			name = arr[0].getText();
			code = Integer.parseInt(arr[1].getText());
			Contructor newContructor = new Contructor(name);
			serviceContructor.add(newContructor);
			contructors.add(new ContructorViewer(newContructor));
			
		}catch(Exception e){
			
		}
	}
	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}
}

