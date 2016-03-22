package hwSecondWeek;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {
		public static void main(String[] args) {
			launch(args);
		}

		@Override
		public void start(Stage stage) throws Exception {
			stage.setTitle("Calculator");
			stage.setScene(createScene());
			stage.show();
			
		}
		
		public Scene createScene(){
			//HBox box = new HBox();
			GridPane pane = new GridPane();
			BorderPane root = new BorderPane();
			Label label = new Label();
			TextArea area = new TextArea();
			Scene scene = new Scene(pane, 600, 400);
			
			return null;
			
		}
}
