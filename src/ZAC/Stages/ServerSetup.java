package ZAC.Stages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerSetup extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ServerSetup.fxml"));
        stage.setTitle("ZAC@Server-Setup");
        stage.setScene(new Scene(root, 150, 200));
        stage.setResizable(false);
        stage.show();

        this.stage = stage;
    }

    @FXML private void selected_Run()throws Exception{

        stage.close();
        ServerControl serverControl = new ServerControl();//TODO make get port from field
        serverControl.setPort(9191);
        serverControl.start(stage);
    }

}
