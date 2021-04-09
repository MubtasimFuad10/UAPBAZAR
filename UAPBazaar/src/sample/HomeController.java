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
        System.out.println(View.Home.getFileName());
        SceneSwitcher.switchTo(View.Food);

    }
    public void switchToClothing()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Home.getFileName());
        SceneSwitcher.switchTo(View.Clothing);
    }
    public void switchToElectronic()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Home.getFileName());
        SceneSwitcher.switchTo(View.Electronic);
    }

    public void switchToCart()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Home.getFileName());
        SceneSwitcher.switchTo(View.Cart);
    }
    public void backToHome()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Cart.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }
}
