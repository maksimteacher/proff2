package chat;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {
	
	Client client;
	Server server;
	
	@Override
	public void init() {
		server = Server.builder();
		server.start();
		client = new Client();
		client.start();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {	
		primaryStage.setTitle("My Chat");
		primaryStage.setScene(createScene());
		primaryStage.show();
		primaryStage.setOnCloseRequest(wc -> {
			client.shutDownDaemons();
			server.shutDownDaemons();
			System.out.println(Thread.activeCount());
		});
	}

	private Scene createScene() {
		VBox chat = new VBox();
		chat.setAlignment(Pos.CENTER);
		
		MyTextArea previousTexts = new MyTextArea(client.getFile());
		client.passTextArea(previousTexts);
		previousTexts.setEditable(false);
		previousTexts.setWrapText(true);
		previousTexts.setId("previousText");
		previousTexts.loadHistory(); 
		
		TextArea enterText = new TextArea();
		enterText.setMaxHeight(40);
		enterText.setMaxWidth(150);
		enterText.setWrapText(true);
		
		Button button = new Button("Send");
		button.setOnAction((e) -> {
			String s = enterText.getText();
			client.sendNewMessage(s);
			enterText.clear();		
		});
		
		
		chat.getChildren().addAll(previousTexts, enterText, button);
		Scene scene = new Scene(chat, 150, 200);
		
		File f = new File("src/main/java/chat/stylesheet.css");
		
		try {
			scene.getStylesheets().add(f.toURI().toURL().toExternalForm());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return scene;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
