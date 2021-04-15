package sample.ui;

import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class LogInController {
    public TextField emailField;
    public TextField passwordField;

    public void logIn() throws Exception {
        Main.auth.logIn(emailField.getText(), passwordField.getText());
    }
}
