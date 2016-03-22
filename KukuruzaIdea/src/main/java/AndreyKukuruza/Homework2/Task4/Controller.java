package AndreyKukuruza.Homework2.Task4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text actionTarget;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        actionTarget.setText("Sign button is pressed    ");
    }
}
