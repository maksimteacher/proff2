package loginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application {
	private int i;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login form");
        
        GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
       
         
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
         
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
         
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
         
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
         
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        
        hbBtn.setBorder(null);
        grid.add(hbBtn, 1, 3);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 3);
        
        TextArea txt = new TextArea();
        grid.add(txt, 1, 4);
        txt.setMaxWidth(140);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
            	
                txt.setText(txt.getText() + i++ + ": " + userTextField.getText() + ", " + pwBox.getText() + ";\n" );
                userTextField.setText("");
                pwBox.setText("");
            }
        });
        
        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);
//        grid.setGridLinesVisible(true);
        primaryStage.show();
    }

}
