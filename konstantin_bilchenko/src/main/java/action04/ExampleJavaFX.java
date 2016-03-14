package action04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ExampleJavaFX extends Application  {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("My App");
		stage.setScene(createScene());
		stage.show();
	}

	private Scene createScene() {
		HBox box = new HBox();
		
		
		
		Label lb = new Label("Enter something");
		Button btn = new Button("Save");
		TextField edit = new TextField();
		edit.setMinWidth(250);
		
		box.getChildren().add(lb);
		box.getChildren().add(edit);
		box.getChildren().add(btn);
		
		
		Scene scene = new Scene(box, 600 , 400);
		return scene;
	}

}
