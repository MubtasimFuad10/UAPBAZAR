package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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


//    //LogIn for Admin
//    public void switchToAdminPanel() //Login as Admin
//    {
//        System.out.println("Clicked.\n");
//        System.out.println(View.Login.getFileName());
//        SceneSwitcher.switchTo(View.AdminPanel);
//    }
//    public void switchToAdmin() //AdminLists
//    {
//        System.out.println("Clicked.\n");
//        System.out.println(View.AdminPanel.getFileName());
//        SceneSwitcher.switchTo(View.Admin);
//    }

    public void onEmailChange(Object event){
        System.out.println(event);
    }

    public TextField userField;
    public TextField passField;
    public Button logButton;

    public void handle(ActionEvent event) {
        String username = userField.getText();
        String passw = passField.getText();
        System.out.printf("Logged in as %s %s", username, passw);
        switchToHome();
    }

    public TextField email;
    public TextField password;

    public void LogIn(){
        Main.login(email.getText(), password.getText());
    }
}
