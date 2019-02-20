package ZAC.MainClasses;

import ZAC.Stages.Menu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage initializerStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Main.fxml"));
        initializerStage.setTitle("ZAC-initializer");
        initializerStage.setScene(new Scene(root, 200, 200));
        initializerStage.setResizable(false);

        //create main stage
        Menu menu = new Menu();
        menu.start(new Stage());
    }

        public static void main(String[] args) {
        launch(args);
    }
}
