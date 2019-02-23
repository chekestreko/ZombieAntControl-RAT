package ZAC.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ServerControl_Terminal {

    @FXML private TextField command_TF;
    @FXML private TextFlow log_TFlow;
    @FXML private ScrollPane terminal_SPane;

    @FXML public void pressed(KeyEvent e) {

        if(command_TF.getText().trim().length() != 0) {
            if (e.getCode() == KeyCode.ENTER) {

                addLog(command_TF.getText());
            }
        }
    }

    public void addLog(String text){

        Text t = new Text(text+"\n");
        log_TFlow.getChildren().add(t);

        terminal_SPane.setVvalue(1);
        command_TF.setText("");
    }

}
