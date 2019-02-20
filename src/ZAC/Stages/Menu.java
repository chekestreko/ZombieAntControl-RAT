package ZAC.Stages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Menu.fxml"));
        stage.setTitle("ZAC-RAT");
        stage.setScene(new Scene(root, 300, 350));
        stage.setResizable(false);
        stage.show();

        this.stage = stage;
    }

    @FXML private void selected_C()throws Exception{

        stage.close();
        ServerSetup serverSetup = new ServerSetup();
        serverSetup.start(stage);
    }

    @FXML private void selected_T(){

        //TODO make an apk builder
    }

}