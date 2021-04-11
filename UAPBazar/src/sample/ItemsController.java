package sample;
import javafx.scene.control.Button;
public class ItemsController {
    public Button foodButton;
    public void backToHome() //Fooditems to home
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Food.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }
    public void backToHomeCloth() //Clothings to home
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Clothing.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }
    public void backToHomeElectronic() //Electronics to home
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Electronic.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }

    //Items to Cart
    public void foodToCart()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Food.getFileName());
        SceneSwitcher.switchTo(View.Cart);
    }
    public void clothingToCart()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Clothing.getFileName());
        SceneSwitcher.switchTo(View.Cart);
    }
    public void electronicToCart()
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Clothing.getFileName());
        SceneSwitcher.switchTo(View.Cart);
    }


}
