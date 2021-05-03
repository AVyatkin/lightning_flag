package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private Map<String, String> map;

    public void onButtonClick(ActionEvent actionEvent) {
        String text = ((Button) actionEvent.getSource()).getText();
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        startProgram(text, stage);
    }

    private void startProgram(String program, Stage stage) {
        String command = map.get(program);
        if (command != null) {
            Runtime runTime = Runtime.getRuntime();
            try {
                Process process = runTime.exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setIconified(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        map = new HashMap<String, String>();
        map.put("chrome", "/usr/bin/google-chrome-stable");
        map.put("firefox", "firefox");
        map.put("files", "thunar");
        map.put("calc", "mate-calc");
    }
}
