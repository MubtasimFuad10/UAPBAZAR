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
    public void backToHomeCloth() //Fooditems to home
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Clothing.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }
    public void backToHomeElectronic() //Fooditems to home
    {
        System.out.println("Clicked.\n");
        System.out.println(View.Electronic.getFileName());
        SceneSwitcher.switchTo(View.Home);
    }

}
