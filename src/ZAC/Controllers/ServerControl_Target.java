package ZAC.Controllers;

import ZAC.Classes.ClientThread;
import ZAC.Stages.ServerControl;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class ServerControl_Target {

    @FXML
    public ListView client_listv;

    public ServerControl_Target() {

        ServerControl.mController.setServerControl_target(this);
    }

    private List<String> ClientList = new ArrayList<>();

    public void addViewClient(String name) {
        Platform.runLater(() -> {
            client_listv.getItems().add(name);
        });
    }

    public void removeViewClient(String name) {
        Platform.runLater(() -> {
            client_listv.getItems().remove(name);
        });
    }

    public void ItemSelection() {

        client_listv.getSelectionModel().selectedItemProperty().addListener((ChangeListener<String>) (observable, oldValue, newValue) -> {

            System.out.println("oldValue: "+oldValue+" newValue: "+newValue);
        });

    }
}
