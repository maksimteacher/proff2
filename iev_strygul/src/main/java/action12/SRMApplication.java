package action12;

import org.hibernate.SessionFactory;

import dao.ContructorDao;
import dao.ContructorDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
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
import service.ProductService;
import service.ProductServiceImpl;
import util.HibernateUtil;
import view.ContructorPage;
import view.ProductPage;

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
		tab2.setContent(getTab2());
		tabPane.getTabs().add(tab2);

		Tab tab3 = new Tab("Catalogs Users");
		tab3.setContent(getTab2());
		tabPane.getTabs().add(tab3);

		Tab tab4 = new Tab("Catalogs Contructors");
		tab4.setContent(getTab4());
		tabPane.getTabs().add(tab4);

		Tab tab5 = new Tab("List of Orders");
		tab5.setContent(getTab2());
		tabPane.getTabs().add(tab5);
		
		return new Scene(tabPane,800,600);
	
	}
	
	public GridPane getTab1(){
		ProductDao daoImpl = new ProductDaoImpl();
		ProductService servisProduct = new ProductServiceImpl(daoImpl);
		ProductPage page = new ProductPage(servisProduct);
		
		return page.getGridPane();
		
	}
	
	public GridPane getTab4(){
		ContructorDao daoImpl = new ContructorDaoImpl();
		ContructorService serviceContructor = new ContructorServiceImpl(daoImpl);
		ContructorPage page = new ContructorPage(serviceContructor);
		
		return page.getGridPane();
	}
	
	
	public Group getTab2(){
		Group group = new Group();
		group.getChildren().add(new Button("ТУт могла быть ваша реклама!"));
		return group;
	}
	
	public void stop(){
		HibernateUtil.getSessionFactory().close();
	}
}

