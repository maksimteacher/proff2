package view;

import java.util.List;
import domain.User;
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
import service.UserService;

public class UserPage implements TemplatePage {
	private ObservableList<UserViewer> users = FXCollections.observableArrayList();
	private TableView<UserViewer> table = new TableView<UserViewer>();
	private UserService servisUser = null;
	private GridPane panel = new GridPane();
	
	public UserPage(UserService servisUser){
		this.servisUser = servisUser;
		init();
	}
	
	private void init(){
		// From DataBase To ObservableList
		List<User> list = servisUser.getAllUsers();
		for(User us:list) {
			users.add(new UserViewer(us));
		}

		Label label = new Label("Catalog Users");
		label.setLayoutX(140);
		label.setLayoutY(40);
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

		TableColumn<UserViewer, Integer> firstNameCol = new TableColumn<UserViewer, Integer>("id");
		TableColumn<UserViewer, String> secondNameCol = new TableColumn<UserViewer, String>("name");
		TableColumn<UserViewer, String> thirdNameCol = new TableColumn<UserViewer, String>("login");
		TableColumn<UserViewer, String> forthNameCol = new TableColumn<UserViewer, String>("pass");
		TableColumn<UserViewer, Integer> fifthNameCol = new TableColumn<UserViewer, Integer>("empId");

		firstNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, Integer>("id"));
		secondNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, String>("name"));
		thirdNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, String>("login"));
		forthNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, String>("pass"));
		fifthNameCol.setCellValueFactory(new PropertyValueFactory<UserViewer, Integer>("empId"));

		table.setItems(users);

		// table.getColumns().addAll(firstNameCol,secondNameCol,thirdNameCol);
		table.getColumns().add(firstNameCol);
		table.getColumns().add(secondNameCol);
		table.getColumns().add(thirdNameCol);
		table.getColumns().add(forthNameCol);
		table.getColumns().add(fifthNameCol);
		
		// Editable Name
		secondNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		secondNameCol.setOnEditCommit(new EventHandler<CellEditEvent<UserViewer, String>>() {
			@Override
			public void handle(CellEditEvent<UserViewer, String> value) {
				String str = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				UserViewer userViewer = value.getTableView().getItems().get(activeRow);
				userViewer.setName(str);
				
				// update user by DataBase
				servisUser.updateUser(userViewer.toUser());
			}
		});
		
		// Editable Login
		thirdNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		thirdNameCol.setOnEditCommit(new EventHandler<CellEditEvent<UserViewer, String>>() {
			@Override
			public void handle(CellEditEvent<UserViewer, String> value) {
				String str = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				UserViewer userViewer = value.getTableView().getItems().get(activeRow);
				userViewer.setLogin(str);
						
				// update user by DataBase
				servisUser.updateUser(userViewer.toUser());
			}
		});
		
		// Editable Pass
		forthNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		forthNameCol.setOnEditCommit(new EventHandler<CellEditEvent<UserViewer, String>>() {
			@Override
			public void handle(CellEditEvent<UserViewer, String> value) {
				String str = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				UserViewer userViewer = value.getTableView().getItems().get(activeRow);
				userViewer.setPass(str);
								
				// update user by DataBase
				servisUser.updateUser(userViewer.toUser());
			}
		});
				
		// Editable EmpId
		fifthNameCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		fifthNameCol.setOnEditCommit(new EventHandler<CellEditEvent<UserViewer, Integer>>() {
			@Override
			public void handle(CellEditEvent<UserViewer, Integer> value) {
				Integer val = value.getNewValue();
				int activeRow = value.getTablePosition().getRow();
				value.getTableView().getItems().get(activeRow).setEmpId(val);				
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
		User user = users.get(index).toUser(); 
		users.remove(index);
		servisUser.deleteUser(user);
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		
	}

}
