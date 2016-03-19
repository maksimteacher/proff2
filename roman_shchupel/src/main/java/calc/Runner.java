package calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Runner extends Application {

	private Calc calc;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		calc = new Calc();
		stage.setTitle("Calculator");
		final int baseWidth = 360;
		final int baseHeight = 100;

		int btnWidth = (int) baseWidth / 4;

		HBox[] lines = { new HBox(), new HBox(), new HBox(), new HBox() };

		Node[] nodes = { new TextField("0"), new Button("0"), new Button("+"), new Button("="), new Button("7"),
				new Button("8"), new Button("9"), new Button("/"), new Button("4"), new Button("5"), new Button("6"),
				new Button("*"), new Button("1"), new Button("2"), new Button("3"), new Button("-") };

		for (int i = 0; i < nodes.length; i++) {
			// System.out.println(i);
			Node currentNode = nodes[i];
			if (i == 0)
				((TextField) currentNode).setEditable(false);// ((Region)currentNode).setDisable(true);

			((Region) currentNode).setMinWidth(btnWidth);

			if (i <= 3)
				lines[0].getChildren().add(currentNode);
			else if ((i > 3) && (i <= 7))
				lines[1].getChildren().add(currentNode);
			else if ((i > 7) && (i <= 11))
				lines[2].getChildren().add(currentNode);
			else if ((i > 11) && (i <= 15))
				lines[3].getChildren().add(currentNode);

			if (i > 0)
				((Button) currentNode).setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						String str = event.toString();
						System.out.println(str);

						char ch = str.charAt(str.length() - 3);
						System.out.println("'" + ch + "' is pressed");
						calc.inChar(ch);
						((TextField) nodes[0]).setText(calc.getResult());

					}
				});

		}

		

		VBox box = new VBox();
		box.getChildren().addAll(lines[0], lines[1], lines[2], lines[3]);

		stage.setScene(new Scene(box, baseWidth, baseHeight));
		stage.show();

	}

}
