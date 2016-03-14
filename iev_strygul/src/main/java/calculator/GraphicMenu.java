package calculator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		VBox rootNode = new VBox();
		HBox resultBox = new HBox();
		
		HBox functionsPanel = new HBox();
		functionsPanel.setSpacing(4.0);
		
		TextField text = new TextField("0");
		text.setMaxSize(172, 50);
		text.setStyle("-fx-font:bold 20px Arial; -fx-alignment: CENTER_RIGHT");
		text.setEditable(false); //should be false
		
		//Columns
		VBox columns[] = {new VBox(), new VBox(), new VBox(), new VBox()};
		
		Button arrayOfButtons[] = {
		new Button("7"), new Button("4"), new Button("1"), new Button("C"),
		new Button("8"), new Button("5"), new Button("2"), new Button("0"),
		new Button("9"), new Button("6"), new Button("3"), new Button("="),
		new Button("+"), new Button("-"),new Button("/"), new Button("*")};
		
		for(int i = 0; i < arrayOfButtons.length; i++) {
			int j = i/4;
			
			Button bttn = arrayOfButtons[i];
			
			bttn.setMinSize(40, 40);
			bttn.setStyle("-fx-margin:20px");
			bttn.setOnAction(keyEvent -> {
				str = keyEvent.toString();
				char ch = str.charAt(str.length() - 3);
				str = "" + ch;
				if(str.compareTo("C") == 0) {
					text.setText("0");
					myCalc.reset();
				} else {
					myCalc.inString(str);
					text.setText(myCalc.getOperationInString());
				}
				
				});
			
			if(i >= 11) bttn.setStyle("-fx-text-fill: blue");
			if(i == 3) bttn.setStyle("-fx-text-fill: red");
			
			columns[j].getChildren().add(bttn);
		}
		
		for(int i = 0; i < columns.length; i++) {
			columns[i].setSpacing(4);
			functionsPanel.getChildren().add(columns[i]);
		}
		
		final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
			@Override
			public void handle(final KeyEvent keyEvent) {
				str = keyEvent.getCharacter();
				if(str.compareTo("c") == 0) { 
					text.setText("0");
				} else {
					text.setText(myCalc.getOperationInString());
					if(myCalc.getOperationInString().compareTo(myCalc.byZero) == 0) {
						text.clear();
					}
				}
				myCalc.inString(str);
			}
		};
		
		text.setOnKeyTyped(keyEventHandler);
		functionsPanel.setOnKeyTyped(keyEventHandler);
		rootNode.getChildren().addAll(resultBox, functionsPanel);
		resultBox.getChildren().add(text);
		
		
		rootNode.setAlignment(Pos.CENTER);
		
		return new Scene(rootNode);
	}

}
