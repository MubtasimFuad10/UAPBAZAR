package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.models.*;
import sample.models.ClothingProduct;
import sample.models.ElectronicProduct;
import sample.models.FoodProduct;
import sample.models.Product;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Optional;

public class CartController {

    @FXML
    private Button homeButton;
    @FXML
    private Button logOutButton;
    @FXML
    private VBox detailsMenu;
    @FXML
    private ListView<String> detailsListView;
    @FXML
    private Button decreaseButton;
    @FXML
    private TextField quantityField;
    @FXML
    private Button increaseButton;
    @FXML
    private Button removeItemButton;
    @FXML
    private Button clearCartButton;
    @FXML
    private TableView<CartItem> cartListTable;
    @FXML
    private Label totalPrice;
    @FXML
    private TableColumn<CartItem, String> productId;
    @FXML
    private TableColumn<CartItem, String> productName;
    @FXML
    private TableColumn<CartItem, Product.Category> productCategory;
    @FXML
    private TableColumn<CartItem, Integer> productQuantity;
    @FXML
    private TableColumn<CartItem, Double> productTotalPrice;
    @FXML
    private TableColumn<CartItem, Double> productPrice;
    @FXML
    private ListView<String> overviewListView;
    @FXML
    private Button buyNowButton = new Button();

    CartItem selectedCartItem;
    ObservableList detailsList = FXCollections.observableArrayList();
    ObservableList overviewList = FXCollections.observableArrayList();
    ObservableList<CartItem> cartList;

    @FXML
        //Initialize
    void initialize() {
        loadCart();
        loadOverViewList();
        detailsMenu.setVisible(false);
        increaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (selectedCartItem != null) {
                    if (selectedCartItem.getQuantity() > 0) {
                        decreaseButton.setDisable(false);
                    }
                    selectedCartItem.setQuantity(selectedCartItem.getQuantity() + 1);
                    loadDetailsView(selectedCartItem);
                    cartListTable.refresh();
                    loadOverViewList();
                }
            }
        });
        decreaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (selectedCartItem != null) {
                    if (selectedCartItem.getQuantity() - 2 <= 0) {
                        decreaseButton.setDisable(true);
                    }
                    selectedCartItem.setQuantity(selectedCartItem.getQuantity() - 1);
                    loadDetailsView(selectedCartItem);
                    cartListTable.refresh();
                    loadOverViewList();
                }
            }
        });
        removeItemButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (selectedCartItem != null) {
                    Main.cart.removeCartItem(selectedCartItem.getProduct().getId());
                    loadCart();
                    detailsMenu.setVisible(false);
                    selectedCartItem = null;
                    loadOverViewList();
                }
            }
        });
        clearCartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.cart.removeAll();
                loadCart();
                detailsMenu.setVisible(false);
                selectedCartItem = null;
                loadOverViewList();
            }
        });

        cartListTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                loadDetailsView(newSelection);
            }
        });

        logOutButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.auth.logOut();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.screenController.activate("home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        buyNowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert dialogBox = new Alert(Alert.AlertType.INFORMATION, "Bill Pain " + Main.cart.getTotalPrice() + "Tk");
                Optional<ButtonType> result = dialogBox.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("Pressed Ok");
                    Main.cart.removeAll();
                    cartList = FXCollections.observableArrayList(Main.cart.getCartItems());
                    cartListTable.setItems(cartList);
                    detailsListView.setVisible(false);
                    detailsMenu.setVisible(false);


                }
            }
        });

    }


    void loadCart() {
        cartList = FXCollections.observableArrayList(Main.cart.getCartItems());
        productId.setCellValueFactory(new PropertyValueFactory<CartItem, String>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<CartItem, String>("name"));
        productCategory.setCellValueFactory(new PropertyValueFactory<CartItem, Product.Category>("category"));
        productQuantity.setCellValueFactory(new PropertyValueFactory<CartItem, Integer>("quantity"));
        productPrice.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("price"));
        productTotalPrice.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("totalPrice"));
        cartListTable.setItems(this.cartList);
    }


    void loadDetailsView(CartItem cartItem) {
        this.selectedCartItem = cartItem;
        updateTotalPrice();
        detailsList.removeAll(detailsList);
        detailsList.add("Id: " + cartItem.getProduct().getId());
        detailsList.add("Name: " + cartItem.getProduct().getName());
        detailsList.add("Category: " + cartItem.getProduct().getCategory());
        if (cartItem.getProduct().getCategory() == Product.Category.Food) {
            FoodProduct foodProduct = (FoodProduct) cartItem.getProduct();
            String pattern = "dd MMM yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(foodProduct.getExpirationDate());
            detailsList.add("Sub Category: " + foodProduct.getSubCategory());
            detailsList.add("Expiration Date: " + date);
        }
        if (cartItem.getCategory() == Product.Category.Electronic) {
            ElectronicProduct electronicProduct = (ElectronicProduct) cartItem.getProduct();
            detailsList.add("Sub Category: " + electronicProduct.getSubCategory().name());
        }
        if (cartItem.getCategory() == Product.Category.Clothing) {
            ClothingProduct clothingProduct = (ClothingProduct) cartItem.getProduct();
            detailsList.add("Sub Category: " + clothingProduct.getSubCategory().name());
        }
        detailsList.add("price: " + cartItem.getProduct().getPrice() + " Tk");
        detailsList.add("Quantity: " + cartItem.getQuantity());
        detailsList.add("Total Price: " + cartItem.getTotalPrice() + " Tk");

        detailsListView.getItems().clear();
        detailsListView.getItems().addAll(detailsList);
        detailsMenu.setVisible(true);
    }

    void updateTotalPrice() {
        if (selectedCartItem != null) {
            quantityField.setText(selectedCartItem.getQuantity() + "");
        }
    }

    void loadOverViewList() {
        overviewList.removeAll(overviewList);
        overviewList.add("Total Items: " + Main.cart.getCartItemCount().toString());
        overviewList.add("Total Price: " + Main.cart.getTotalPrice().toString() + " Tk");
        overviewListView.getItems().clear();
        overviewListView.getItems().addAll(overviewList);
    }
//    public static void showBillPaid(String msg)
//    {
//        Alert dialogBox = new Alert(Alert.AlertType.INFORMATION, "Bill paid "+buyNowButton+ )
//    }
}
