package action04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
		Button btn = new Button("as");
		
		box.getChildren().add(btn);
		
		Scene scene = new Scene(box, 400 , 600);
		return scene;
	}

}
