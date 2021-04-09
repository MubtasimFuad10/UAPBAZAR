package sample;
import javafx.scene.control.Button;
public class HomeController {
    public Button homeButton;
    public void switchToLogin()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Login.getFileName());
        SceneSwitcher.switchTo(View.Login);
    }
}
