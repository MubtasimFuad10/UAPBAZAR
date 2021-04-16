package sample;

import java.io.IOException;

public class Auth {
    boolean isAdminUser = false;
    boolean isLoggedIn = false;

    public void logIn(String email, String password) throws IOException {
        if (email.equals("user@email.com") && password.equals("user")) {
            isAdminUser = false;
            isLoggedIn = true;
            Main.screenController.activate("home");
        } else if (email.equals("admin@email.com") && password.equals("1234")) {
            isAdminUser = true;
            isLoggedIn = true;
            Main.screenController.activate("admin");
        } else {
            System.out.println("Invalid password or email");
        }
    }

    public void logOut() throws IOException {
        isLoggedIn = false;
        isAdminUser = false;
        Main.screenController.activate("login");
    }
}
