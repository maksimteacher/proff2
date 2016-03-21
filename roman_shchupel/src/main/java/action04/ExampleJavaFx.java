package action04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ExampleJavaFx extends Application{
	public static void main(String[] args) {
		launch(args);
	} 
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("My app");
		stage.setScene(createScene());
		stage.show();
		
	}
	public Scene createScene(){
		HBox box = new HBox();
		
		Button btn = new Button("kiss");
		
		box.getChildren().add(btn);
		
		Button btn2 = new Button("my");
		box.getChildren().add(btn2);
		
		TextField tf = new TextField();
		box.getChildren().add(tf);
		
		Scene scene = new Scene(box, 400 , 600);
		return scene;
	}
}
