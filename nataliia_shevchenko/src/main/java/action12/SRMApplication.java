package action12;
import org.hibernate.SessionFactory;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.ContructorService;
import service.ContructorServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import util.HibernateUtil;
import view.ContructorPage;
import view.EmployeePage;
import view.ProductPage;
import view.UserPage;

public class SRMApplication extends Application{
	SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("CRM SYSTEM");
		stage.setScene(createScene());
		stage.show();		
	}
	public Scene createScene(){
		TabPane tabPane = new TabPane();
		
		Tab tab1 = new Tab("Catalog Products");
		tab1.setContent(getTab1());
		tabPane.getTabs().add(tab1);

		Tab tab2 = new Tab("Catalogs Employees");
		//tab2.setContent(getTabAll());
		tab2.setContent(getTab2());
		tabPane.getTabs().add(tab2);

		Tab tab3 = new Tab("Catalogs Users");
		//tab3.setContent(getTabAll());
		tab3.setContent(getTab3());
		tabPane.getTabs().add(tab3);

		Tab tab4 = new Tab("Catalogs Contructors");
		tab4.setContent(getTab4());
		//tab4.setContent(getTabAll());
		tabPane.getTabs().add(tab4);

		Tab tab5 = new Tab("List of Orders");
		tab5.setContent(getTabAll());
		tabPane.getTabs().add(tab5);
		
		return new Scene(tabPane,800,600);
	
	}
	public GridPane getTab1(){
		ProductDao daoImpl = new ProductDaoImpl();
		ProductService servisProduct = new ProductServiceImpl(daoImpl);
		ProductPage page = new ProductPage(servisProduct);
		return page.getGridPane();		
	}
	
	public GridPane getTab2(){
		EmployeeDao daoImpl = new EmployeeDaoImpl();
		EmployeeService servisEmployee = new EmployeeServiceImpl(daoImpl);
		EmployeePage page = new EmployeePage(servisEmployee);
		return page.getGridPane();		
	}
	
	public GridPane getTab3(){
		UserDao daoImpl = new UserDaoImpl();
		UserService servisUser = new UserServiceImpl(daoImpl);
		UserPage page = new UserPage(servisUser);
		return page.getGridPane();		
	}
	
	public GridPane getTab4(){
		ContructorDao daoImpl = new ContructorDaoImpl();
		ContructorService servisContructor = new ContructorServiceImpl(daoImpl);
		ContructorPage page = new ContructorPage(servisContructor);
		
		return page.getGridPane();		
	}
	
	public Group getTabAll(){
		Group group = new Group();
		group.getChildren().add(new Button("Here can be your advertisement!!!"));
		return group;
	}
	public void stop(){
		HibernateUtil.getSessionFactory().close();
	}
}

