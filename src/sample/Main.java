package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.ClothingProduct;
import sample.models.FoodProduct;

import java.time.LocalDate;
import java.util.Objects;

public class Main extends Application {
    public static Store store;
    public static Cart cart;
    public static Auth auth;
    public static ScreenController screenController;
    public static Storage storage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ui/login.fxml")));
        Scene scene = new Scene(root);
        screenController = new ScreenController(scene);
        screenController.addScreen("login", "ui/login.fxml");
        screenController.addScreen("home", "ui/home.fxml");
        screenController.addScreen("cart", "ui/cart.fxml");
        screenController.addScreen("admin", "ui/admin.fxml");
        primaryStage.setTitle("UAP Bazar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        auth = new Auth();
        storage = new Storage();
        storage.createFile();

        launch(args);
    }
}
