package action04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
		stage.setScene(createScene1());
		stage.show();
		
	}
	Button btn3 = new Button("as 3");
	TextField text = new TextField();
	
	public Scene createScene(){
		HBox box = new HBox();
		
		Button btn1 = new Button("as 1");
		Button btn2 = new Button("as 2");
		
		box.getChildren().add(btn1);
		box.getChildren().add(btn2);
		box.getChildren().add(btn3);
		box.getChildren().add(text);
		
		text.setMinWidth(400);
		
		btn1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("btn1 click");				
			}			
		});
		btn2.setOnAction(new MyEvent());
		btn3.setOnAction(new MyEvent());
		
		Scene scene = new Scene(box, 400 , 600);
		return scene;
	}
	public Scene createScene1(){
		VBox mainBox = new VBox();
		
		HBox box1 = new HBox();
		HBox box2 = new HBox();
		
		Button btn1 = new Button("as 1");
		Button btn2 = new Button("as 2");
		
		mainBox.getChildren().add(box1);
		mainBox.getChildren().add(box2);
		
		box1.getChildren().add(btn1);
		box1.getChildren().add(btn2);
		box2.getChildren().add(btn3);
		box2.getChildren().add(text);
		
		
		btn1.setStyle("-fx-background-color:red; -fx-font-size:20px;-fx-text-color:white");
		
		text.setMinWidth(400);
		
		btn1.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("btn1 click");				
			}			
		});
		btn2.setOnAction(new MyEvent());
		btn3.setOnAction(new MyEvent());
		
		Scene scene = new Scene(mainBox, 400 , 600);
		return scene;
	}
	
	class MyEvent implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			if(event.getSource() == btn3) System.out.print("btn3 ");
			System.out.println("click");
			text.setText(text.getText()+" " + event.getSource().getClass().getSimpleName());
		}		
	}
}
