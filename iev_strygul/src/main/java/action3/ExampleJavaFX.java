package action3;

import org.hibernate.cfg.CreateKeySecondPass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ExampleJavaFX extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Try JavaFX");
		myStage.setScene(CreateScene());
		myStage.show();
		
	}

	private Scene CreateScene() {
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		
		Label lab1 = new Label();
		
		TextField text = new TextField();
		
		Button btn = new Button("button");
		btn.setOnAction((event) -> {
			lab1.setText("Alloha!");
			text.setText("Kyky");
		});
		
		box.getChildren().addAll(btn, lab1, text);
		
		Scene scene = new Scene(box, 400, 600);
		return scene;
	}

}
