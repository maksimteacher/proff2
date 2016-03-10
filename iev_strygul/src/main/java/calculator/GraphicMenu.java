package calculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GraphicMenu extends Application {
	
	String str;
	MyCalculator myCalc = new MyCalculator();

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Mega Super Cool Calculator - 2016");
		myStage.setScene(createScene());
		myStage.show();
		
	}
	
	public Scene createScene() {
		FlowPane rootNode = new FlowPane(20, 20);
		rootNode.setAlignment(Pos.CENTER);
		
		Label lb1 = new Label("Enter an operation, or 'c' to reset");
		Label result = new Label("Result will be displayed here");
		
		TextField text = new TextField();
		text.setOnKeyTyped(keyEvent ->  {
			str = keyEvent.getCharacter();
			
			if(str.compareTo("c") == 0) {
				myCalc.reset();
				text.clear();
				result.setText(myCalc.getOperationInString());
			} else {
				myCalc.inString(str);
				result.setText(myCalc.getOperationInString());
				if(myCalc.getOperationInString().compareTo(myCalc.byZero) == 0) {
					text.clear();
				}
			}
		});
		
		rootNode.getChildren().addAll(lb1, text, result);
		
		return new Scene(rootNode, 200, 200);
	}

}
