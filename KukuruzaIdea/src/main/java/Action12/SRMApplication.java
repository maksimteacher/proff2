package Action12;

import Action11.dao.ContructorDao;
import Action11.dao.ContructorDaoImpl;
import Action11.dao.ProductDao;
import Action11.dao.ProductDaoImpl;
import Action11.util.HibernateUtil;
import Action12.service.ContructorService;
import Action12.service.ContructorServiceImpl;
import Action12.service.ProductService;
import Action12.service.ProductServiceImpl;
import Action12.view.ContructorPage;
import Action12.view.ProductPage;
import org.hibernate.SessionFactory;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SRMApplication extends Application {
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

    public Scene createScene() {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Catalog Products");
        tab1.setContent(getTab1());
        tabPane.getTabs().add(tab1);

        Tab tab2 = new Tab("Catalogs Employees");
        tab2.setContent(getTab3());
        tabPane.getTabs().add(tab2);

        Tab tab3 = new Tab("Catalogs Users");
        tab3.setContent(getTab3());
        tabPane.getTabs().add(tab3);

        Tab tab4 = new Tab("Catalogs Products");
        tab4.setContent(getTab3());
        tabPane.getTabs().add(tab4);

        Tab tab5 = new Tab("List of Orders");
        tab5.setContent(getTab3());
        tabPane.getTabs().add(tab5);

        Tab tab6 = new Tab("List of Contructors");
        tab6.setContent(getTab2());
        tabPane.getTabs().add(tab6);
        return new Scene(tabPane, 800, 600);

    }

    public GridPane getTab1() {
        ProductDao daoImpl = new ProductDaoImpl(factory);
        ProductService productService = new ProductServiceImpl(daoImpl);
        ProductPage page = new ProductPage(productService);
        return page.getGridPane();
    }

    public GridPane getTab2() {
        ContructorDao daoImpl = new ContructorDaoImpl(factory);
        ContructorService contructorService = new ContructorServiceImpl(daoImpl);
        ContructorPage page = new ContructorPage(contructorService);

        return page.getGridPane();

    }

    public Group getTab3() {
        Group group = new Group();
        group.getChildren().add(new Button("loloolo"));
        return group;
    }

    public void stop() {
        HibernateUtil.getSessionFactory().close();
    }
}

