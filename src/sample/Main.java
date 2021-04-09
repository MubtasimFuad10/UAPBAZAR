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
            setUserAgentStylesheet(STYLESHEET_MODENA);
            Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));

            Scene beginScene=new Scene(root);
            SceneSwitcher.setScene(beginScene);
            window.setScene(beginScene);
            window.show();

        //Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
//        primaryStage.setTitle("UAP Bazaar");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
    }


}