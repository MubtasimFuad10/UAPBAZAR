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
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
    private Button buyNowButton;


    CartItem selectedCartItem;
    ObservableList detailsList = FXCollections.observableArrayList();
    ObservableList overviewList = FXCollections.observableArrayList();
    ObservableList<CartItem> cartList;

    @FXML
    void initialize() {


        loadCart();
        loadOverViewList();
        detailsMenu.setVisible(false);
        decreaseButton.setDisable(true);
        quantityField.setDisable(true);

        increaseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (selectedCartItem != null) {
                    if (selectedCartItem.getQuantity() > 0) {
                        decreaseButton.setDisable(false);
                    }
                    int quantity = selectedCartItem.getQuantity() +1 ;
                    if (quantity >= selectedCartItem.getProduct().getQuantity()) {
                        increaseButton.setDisable(true);
                    }
                    selectedCartItem.setQuantity(quantity);
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

                    int quantity = selectedCartItem.getQuantity() - 1;
                    if (quantity <= selectedCartItem.getProduct().getQuantity()) {
                        increaseButton.setDisable(false);
                    }
                    selectedCartItem.setQuantity(quantity);
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
                buyNow();
            }
        });

    }

    void loadCart() {
        cartList = FXCollections.observableArrayList(Main.cart.getCartItems());
        productId.setCellValueFactory(new PropertyValueFactory<CartItem, String>("id"));
        productName.setCellValueFactory(new PropertyValueFactory<CartItem, String>("name"));
        productCategory.setCellValueFactory(new PropertyValueFactory<CartItem, Product.Category>("category"));
        productQuantity.setCellValueFactory(new PropertyValueFactory<CartItem, Integer>("quantity"));
        productPrice.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("salePrice"));
        productTotalPrice.setCellValueFactory(new PropertyValueFactory<CartItem, Double>("totalPrice"));
        cartListTable.setItems(this.cartList);
    }

    void buyNow() {
        Alert dialogBox = new Alert(Alert.AlertType.INFORMATION, "Bill Paid " + Main.cart.getTotalPrice() + "Tk");
        Optional<ButtonType> result = dialogBox.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("Pressed Ok");
            Main.cart.buyAllItems();
            cartList = FXCollections.observableArrayList(Main.cart.getCartItems());
            cartListTable.setItems(cartList);
            detailsListView.setVisible(false);
            detailsMenu.setVisible(false);
            overviewListView.getItems().clear();
        }
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
            detailsList.add("Sub Category: " + foodProduct.getSubCategory());
            detailsList.add("Expiration Date: " + foodProduct.getExpirationDate().format(DateTimeFormatter.ISO_DATE));
        }
        if (cartItem.getCategory() == Product.Category.Electronic) {
            ElectronicProduct electronicProduct = (ElectronicProduct) cartItem.getProduct();
            detailsList.add("Sub Category: " + electronicProduct.getSubCategory().name());
        }
        if (cartItem.getCategory() == Product.Category.Clothing) {
            ClothingProduct clothingProduct = (ClothingProduct) cartItem.getProduct();
            detailsList.add("Sub Category: " + clothingProduct.getSubCategory().name());
        }
        detailsList.add("price: " + new DecimalFormat("#.00 TK").format(cartItem.getProduct().getSalePrice()));
        detailsList.add("Quantity: " + cartItem.getQuantity());
        detailsList.add("Total Price: " + new DecimalFormat("#.00 TK").format(Main.cart.getTotalPrice()));


        detailsListView.getItems().clear();
        detailsListView.getItems().addAll(detailsList);
        detailsMenu.setVisible(true);
    }


//    void loadDetailsView(Product product) {
//        increaseButton.setDisable(false);
//        decreaseButton.setDisable(true);
//        if (selectedProduct == null || product != selectedProduct) {
//            this.quantity = 1;
//            selectedProduct = product;
//        }
//        updateTotalPrice();
//        detailsList.removeAll(detailsList);
//        detailsList.add("Id: " + product.getId());
//        detailsList.add("Name: " + product.getName());
//        detailsList.add("Category: " + product.getCategory());
//        if (product.getCategory() == Product.Category.Food) {
//            FoodProduct foodProduct = (FoodProduct) product;
//
//            detailsList.add("Sub Category: " + foodProduct.getSubCategory());
//            detailsList.add("Expiration Date: " + foodProduct.getExpirationDate().format(DateTimeFormatter.ISO_DATE));
//        }
//        if (product.getCategory() == Product.Category.Electronic) {
//            ElectronicProduct electronicProduct = (ElectronicProduct) product;
//            detailsList.add("Sub Category: " + electronicProduct.getSubCategory().name());
//        }
//        if (product.getCategory() == Product.Category.Clothing) {
//            ClothingProduct clothingProduct = (ClothingProduct) product;
//            detailsList.add("Sub Category: " + clothingProduct.getSubCategory().name());
//        }
//        detailsList.add("Regular Price: " + new DecimalFormat("#.00 TK").format(product.getPrice()));
//        detailsList.add("Sale Price: " + new DecimalFormat("#.00 TK").format(product.getSalePrice()) + "  (-" + product.getPercentage() + "%)");
//        detailsList.add("Stock: " + (product.getQuantity() > 0 ? product.getQuantity() : "Out of Stock"));
//
//        detailsListView.getItems().clear();
//        detailsListView.getItems().addAll(detailsList);
//        detailsMenu.setVisible(true);
//    }

    void updateTotalPrice() {
        if (selectedCartItem != null) {
            quantityField.setText(selectedCartItem.getQuantity() + "");
        }
    }

    void loadOverViewList() {
        overviewList.removeAll(overviewList);
        overviewList.add("Total Items: " + Main.cart.getCartItemCount().toString());
        overviewList.add("Total Price: " + new DecimalFormat("#.00 TK").format(Main.cart.getTotalPrice()));
        overviewListView.getItems().clear();
        overviewListView.getItems().addAll(overviewList);

    }
}
