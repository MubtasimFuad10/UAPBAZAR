package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.HashMap;

public class ScreenController {
    private HashMap<String, String> screenMap = new HashMap<>();
    private Scene main;

    public ScreenController(Scene main) {
        this.main = main;
    }

    public void addScreen(String name, String fxml){
        screenMap.put(name, fxml);
    }

    public void removeScreen(String name){
        screenMap.remove(name);
    }

    public void activate(String name) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(screenMap.get(name)));
        main.setRoot(pane);
    }
}
