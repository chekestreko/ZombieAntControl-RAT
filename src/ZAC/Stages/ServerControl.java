package ZAC.Stages;

import ZAC.MainClasses.ServerConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerControl extends Application {

    private int port;
    //private static Stage stage;

    public ServerControl(int port){

        this.port = port;
    }

    @Override
    public void start(Stage stage) throws Exception{

        ServerConnection server = new ServerConnection(port);
        server.start();

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ServerControl.fxml"));
        stage.setTitle("ZAC@Server");
        stage.setScene(new Scene(root, 970, 540));
        stage.setResizable(true);
        stage.show();

        //this.stage = stage;


    }
}