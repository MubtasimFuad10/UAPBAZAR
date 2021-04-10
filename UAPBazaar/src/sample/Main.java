package sample;

import sample.SceneSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

            Stage window= primaryStage;
            setUserAgentStylesheet(STYLESHEET_CASPIAN);
            Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));

            Scene scene=new Scene(root);
            SceneSwitcher.setScene(scene);
            window.setScene(scene);
            window.setTitle("UAP Bazaar");
            window.show();


    }


}