package sample;
import javafx.scene.control.Button;
public class HomeController {
    public Button homeButton;
    public Button foodButton;
    public Button clothingButton;
    public Button electronicButton;
    public void switchToFood()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Food.getFileName());
        SceneSwitcher.switchTo(View.Food);

    }
    public void switchToClothing()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Clothing.getFileName());
        SceneSwitcher.switchTo(View.Clothing);
    }
    public void switchToElectronic()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Electronic.getFileName());
        SceneSwitcher.switchTo(View.Electronic);
    }

    public void switchToCart()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Home.getFileName());
        SceneSwitcher.switchTo(View.);
    }
}
