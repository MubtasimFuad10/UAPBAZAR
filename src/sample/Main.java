package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import sample.models.ClothingProduct;
import sample.models.ElectronicProduct;
import sample.models.FoodProduct;

import java.util.Date;
import java.util.Objects;

public class Main extends Application   {
    public static Store store;
    public static Cart cart;
    public static Auth auth;
    public static ScreenController screenController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ui/login.fxml")));
        Scene scene = new Scene(root);
        screenController = new ScreenController(scene);
        screenController.addScreen("login", "ui/login.fxml");
        screenController.addScreen("admin", "ui/admin.fxml");
        screenController.addScreen("home", "ui/home.fxml");
        screenController.addScreen("cart", "ui/cart.fxml");
        primaryStage.setTitle("UAP Bazaar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        auth = new Auth();

//        store.addClothingProduct("Men's Pant", 500.0, ClothingProduct.SubCategory.Pant, 50, 450.0, 10);
//        store.addClothingProduct("Women's Pant", 1000.0, ClothingProduct.SubCategory.Pant, 50, 900.0,10);
//        store.addFoodProduct("Kacchi", 150.0, new Date(), FoodProduct.SubCategory.Meal, 10, 135.0,10);
//        store.addElectronicProduct("PC", 80000.0, ElectronicProduct.SubCategory.Computer, 80, 72000.0,10);
//        store.addClothingProduct("Mask", 120.0, ClothingProduct.SubCategory.Mask, 50, 108.0,10);
      launch(args);
    }







}
