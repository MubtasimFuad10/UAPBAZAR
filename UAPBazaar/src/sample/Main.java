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

           // login("user@test.com", "1234");
    }

    public static void login(String email, String pass){
         String userEmail = "user@test.com";
         String adminEmail = "admin@test.com";
         String password = "1234";

        if(email.equals(userEmail) && pass.equals(password)){
            // normal user
            System.out.println("Normal User");
            SceneSwitcher.switchTo(View.Home);
        }else if(email.equals(adminEmail) && pass.equals(password)){
            // admin user
            System.out.println("Admin User");
            SceneSwitcher.switchTo(View.Admin);
        }else{
            // user not found
            System.out.println("User Not Found");
        }
    }

}