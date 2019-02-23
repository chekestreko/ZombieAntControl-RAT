package ZAC.Stages;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerControl extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ServerControl.fxml"));
        stage.setTitle("ZAC@Server");
        stage.setScene(new Scene(root, 970, 540));
        stage.setResizable(true);
        stage.show();

        this.stage = stage;
    }
}