package sample;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class HomeController {

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

    public static void main(String[] args) {
    }

    public ListView<String> listView;

    public void showFoodItems(){
        this.listView.getItems().clear();
        this.listView.getItems().add("Food Item 1");
        this.listView.getItems().add("Food Item 2");
        this.listView.getItems().add("Food Item 3");
        this.listView.getItems().add("Food Item 4");
    }
    public void showElectronicsItems(){
        this.listView.getItems().clear();
        listView.getItems().add("Electronics Item 1");
        listView.getItems().add("Electronics Item 2");
        listView.getItems().add("Electronics Item 3");
        listView.getItems().add("Electronics Item 4");
    }
    public  void showClothingItems(){
        this.listView.getItems().clear();
        listView.getItems().add("Clothing Item 1");
        listView.getItems().add("Clothing Item 2");
        listView.getItems().add("Clothing Item 3");
        listView.getItems().add("Clothing Item 4");
    }
}
