package action04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		
		VBox vbox = new VBox();
		
		Button btn1 = new Button("as");
		Button btn2 = new Button("as11111");
		
		btn1.setOnAction(new MyEvent());
		
		vbox.getChildren().add(btn1);
		vbox.getChildren().add(btn2);
		
		Scene scene = new Scene(vbox, 400 , 600);
		return scene;
	}
	
	
	class MyEvent implements EventHandler<ActionEvent>{

		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			
		}
				
	}

}

