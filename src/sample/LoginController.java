package sample;

import javafx.scene.control.Button;

public class LoginController {
    public Button loginButton;
    public void switchToHome()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Login.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }

    //Controller For SignUP Fxml

    public void switchToSignUp()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.SignUp.getFileName());
        SceneSwitcher.switchTo(View.SignUp);
    }
    public void backToLogIn()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.SignUp.getFileName());
        SceneSwitcher.switchTo(View.Login);
    }
    public void goToLogIn()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.SignUp.getFileName());
        SceneSwitcher.switchTo(View.Login);
    }

}
