package ZAC.Stages;

import ZAC.Classes.ClientThread;
import ZAC.MainClasses.MainController;
import ZAC.MainClasses.ServerConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerControl extends Application {

    private int port;

    public void setPort(int port){

        this.port = port;
    }

    public static MainController mController;

    @Override
    public void start(Stage stage) throws Exception{

        mController = new MainController();

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/ServerControl.fxml"));
        stage.setTitle("ZAC@Server");
        stage.setScene(new Scene(root, 970, 540));
        stage.setResizable(true);

        mController.initializa();

        stage.show();

        new ServerConnection(port).start();
    }

    public void addConnection(ClientThread connection){


    }
}