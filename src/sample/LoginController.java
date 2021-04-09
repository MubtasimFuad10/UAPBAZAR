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

    public void switchToSignUp() //For signup
    {
        System.out.println("Clicked.\n");
        System.out.println(View.SignUp.getFileName());
        SceneSwitcher.switchTo(View.SignUp);
    }
    public void backToLogIn() //After finishing signup, login login as a user.
    {
        System.out.println("Clicked.\n");
        System.out.println(View.SignUp.getFileName());
        SceneSwitcher.switchTo(View.Login);
    }
    public void goToLogIn() //If already have a account
    {
        System.out.println("Clicked.\n");
        System.out.println(View.SignUp.getFileName());
        SceneSwitcher.switchTo(View.Login);
    }


    //LogIn for Admin
    public void switchToAdminPanel() //Login as Admin
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Login.getFileName());
        SceneSwitcher.switchTo(View.AdminPanel);
    }
    public void switchToAdmin() //AdminLists
    {
        System.out.println("Clicked.\n");
        System.out.println(View.AdminPanel.getFileName());
        SceneSwitcher.switchTo(View.Admin);
    }

}
