package ZAC.Controllers;

import ZAC.Stages.ServerControl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ServerControl_Terminal {

    @FXML private  TextField command_TF;
    @FXML private  TextFlow log_TFlow;
    @FXML private  ScrollPane terminal_SPane;

    public ServerControl_Terminal(){

        ServerControl.mController.setServerControl_terminal(this);
        System.out.println("Running ");
    }

    @FXML public void pressed(KeyEvent e) {

        if (e.getCode() == KeyCode.ENTER) {

            if(command_TF.getText().trim().length() != 0) {

                    addLogText(command_TF.getText());

                    command_TF.setText("");
            }

        }

    }

    public void addLogText(String text){
        Platform.runLater(() -> {
            Text t = new Text(text+"\n");
            log_TFlow.getChildren().add(t);

            terminal_SPane.setVvalue(1);
            command_TF.setText("");
        });
    }

    public void addLog(String prefixText, String prefixWebColor, String text, String webColor){
        Platform.runLater(() -> {
            Text t1 = new Text(prefixText+" ");
            t1.setFill(Color.web(prefixWebColor));

            Text t2 = new Text(text+"\n");
            t2.setFill(Color.web(webColor));
            log_TFlow.getChildren().add(t1);
            log_TFlow.getChildren().add(t2);

            terminal_SPane.setVvalue(1);
        });
    }

}
