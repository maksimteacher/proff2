package view;

import java.util.List;

import domain.Employee;
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
import javafx.util.converter.IntegerStringConverter;
import service.EmployeeService;


public class EmployeePage implements TemplatePage {
	private ObservableList<EmployeeViewer> employees = FXCollections.observableArrayList();
	private TableView<EmployeeViewer> table = new TableView<EmployeeViewer>();
	private EmployeeService servisEmployee = null;
	private GridPane panel = new GridPane();
	
	public EmployeePage(EmployeeService servisEmployee){
		this.servisEmployee = servisEmployee;
		init();
	}
	
	private void init(){
		// From DataBase To ObservableList
		List<Employee> list = servisEmployee.getAllEmployees();
		for(Employee empl:list) {
			employees.add(new EmployeeViewer(empl));
		}

		Label label = new Label("Catalog Employees");
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

		TableColumn<EmployeeViewer, Integer> firstNameCol = new TableColumn<EmployeeViewer, Integer>("id");
		TableColumn<EmployeeViewer, String> secondNameCol = new TableColumn<EmployeeViewer, String>("name");
		TableColumn<EmployeeViewer, Integer> thirdNameCol = new TableColumn<EmployeeViewer, Integer>("salary");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<EmployeeViewer, Integer>("salary"));

		table.setItems(employees);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);
		table.getColumns().add(thirdNameCol);
		
		// Editable Name
		secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<EmployeeViewer, String>>() {
			@Override
			public void handle(CellEditEvent<EmployeeViewer, String> value) {
				String str = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				EmployeeViewer employeeViewer = value.getTableView().getItems().get(activeRow);
				employeeViewer.setName(str);
				
				// update product by DataBase
				servisEmployee.updateEmployee(employeeViewer.toEmployee());
			}
		});
		// Editable Code
		thirdNameCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		thirdNameCol.setOnEditCommit(new EventHandler<CellEditEvent<EmployeeViewer, Integer>>() {
			@Override
			public void handle(CellEditEvent<EmployeeViewer, Integer> value) {
				Integer val = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				value.getTableView().getItems().get(activeRow).setSalary(val);				
			}
		});
	}	

	public  GridPane getGridPane(){
		return panel;
	}

	@Override
	public void add(TextField[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		int index = table.editingCellProperty().get().getRow();
		Employee employee = employees.get(index).toEmployee(); 
		employees.remove(index);
		servisEmployee.deleteEmployee(employee);
		
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
