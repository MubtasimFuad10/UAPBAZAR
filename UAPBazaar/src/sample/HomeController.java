package sample;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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

    public void logOut(){
        SceneSwitcher.switchTo(View.Login);
    }


    public ListView<String> listView;
    public ListView<String> foodItems;
    public ListView<String> electronicsItems;
    public ListView<String> clothingItems;

    public HomeController(){
        listView = new ListView<String>();
        foodItems = new ListView<String>();
        electronicsItems = new ListView<String>();
        clothingItems = new ListView<String>();
        this.foodItems.getItems().add("Food Item 1");
        this.foodItems.getItems().add("Food Item 2");
        this.foodItems.getItems().add("Food Item 3");
        this.foodItems.getItems().add("Food Item 4");

        electronicsItems.getItems().add("Electronics Item 1");
        electronicsItems.getItems().add("Electronics Item 2");
        electronicsItems.getItems().add("Electronics Item 3");
        electronicsItems.getItems().add("Electronics Item 4");

        clothingItems.getItems().add("Clothing Item 1");
        clothingItems.getItems().add("Clothing Item 2");
        clothingItems.getItems().add("Clothing Item 3");
        clothingItems.getItems().add("Clothing Item 4");


        listView.getItems().add("Clothing Item 1");
        listView.getItems().add("Clothing Item 2");
        listView.getItems().add("Clothing Item 3");
        listView.getItems().add("Clothing Item 4");
    }

    public static void main(String[] args) {

    }

    public void showFoodItems(){
//        this.listView = foodItems;
        System.out.println("Food Items");
    }
    public void showElectronicsItems(){
//        this.listView = electronicsItems;
        System.out.println("Electronics Items");
    }
    public  void showClothingItems(){
//        this.listView = clothingItems;
        System.out.println("Clothing Items");
    }
}
