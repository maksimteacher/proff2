package calculator;

import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalcApp extends Application {
	private Calc calculator;
	
	{
		calculator = new Calc();
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Int Calculator");
		stage.setScene(createScene());
		stage.show();
	}

	private Scene createScene() {
		System.out.println("Calculator started");
		VBox calc = new VBox();
		HBox screen = new HBox();
		HBox panel = new HBox();
		calc.getChildren().add(screen);
		calc.getChildren().add(panel);
		
		TextField result = new TextField("0");
		result.setEditable(false);
		screen.getChildren().add(result);
		
		VBox[] cols = new VBox[5];
		for (int i = 0 ; i < cols.length ; i++) {
			cols[i] = new VBox();
		}
		
		int i = 0;
		for (VBox box : cols) {
			panel.getChildren().add(cols[i++]);
		}
//		System.out.println(Arrays.toString(cols));
		Button[] bttns = {new Button("7"), new Button("4"), new Button("1"),
						  new Button("8"), new Button("5"), new Button("2"),
						  new Button("9"), new Button("6"), new Button("3"),
						  new Button("/"), new Button("-"), new Button("0"),
						  new Button("*"), new Button("+"), new Button("=")
		};
//		System.out.println(Arrays.toString(bttns));
		for (i = 0 ; i < bttns.length ; i++) {
			int j = i / 3;
//			System.out.println(i + " " + j);
			cols[j].getChildren().add(bttns[i]);
			bttns[i].setMinSize(30, 30);
			bttns[i].setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent e) {
					String str = e.toString();
//					System.out.println(str);
					char c = str.charAt(str.length() - 3);
					System.out.println("'" + c + "' is pressed");
					calculator.inChar(c);
					result.setText(calculator.getResult());
					
				}
				
			});
		}

//		System.out.println("333");
		
		
		Scene scene = new Scene(calc, 150 , 120);
		return scene;
	}
	
}

