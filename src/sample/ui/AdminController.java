package sample.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.enums.Category;
import sample.models.*;

import java.io.IOException;
import java.util.ArrayList;


public class AdminController {
    @FXML
    private ListView<String> tabsListView;
    @FXML
    private Button viewHome;
    @FXML
    private Button logOut;
    @FXML
    private TextField searchTextField;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> productName;
    @FXML
    private TableColumn<Product, String> productId;
    @FXML
    private TableColumn<Product, Product.Category> productCategory;
    @FXML
    private TableColumn<Product, Double> productPrice;
    @FXML
    private TableColumn<Product, Integer> productQuantity;
    @FXML
    private TableColumn<Product, Double> productSalePrice;
    @FXML
    private TableColumn<Product, Integer> productDiscount;

    @FXML
    private  TabPane tabPane;
    @FXML
    public Tab productsTab;
    @FXML
    public Tab addProductTab;

    ObservableList tabItems = FXCollections.observableArrayList();
    ObservableList<Product> productList;

    @FXML
    void initialize() {
        initializeTabs();
        handleSearch();
        viewHome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.screenController.activate("home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        logOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Main.auth.logOut();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        tabPane.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                        initializeTabs();
                    }
                }
        );
    }

    void changeTab(Tab tab){
        SingleSelectionModel<Tab> tabs = tabPane.getSelectionModel();
        tabs.select(tab);
    }

    void initializeTabs() {
        tabItems.removeAll(tabItems);
        for (int i = 0; i < Category.values().length; i++) {
            tabItems.add(getLabel(Category.values()[i].name()));
        }
        tabsListView.getItems().clear();
        tabsListView.getItems().addAll(tabItems);
        tabsListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null && !newSelection.equals(oldSelection)) {
                if (newSelection.equals(getLabel(Category.All.name()))) {
                    showAllItems();
                } else if (newSelection.equals(getLabel(Category.Food.name()))) {
                    showFoodItems();
                } else if (newSelection.equals(getLabel(Category.Electronic.name()))) {
                    showElectronicItems();
                } else if (newSelection.equals(getLabel(Category.Clothing.name()))) {
                    showClothingItems();
                }
            }
        });
        tabsListView.getSelectionModel().selectFirst();
    }

    String getLabel(String name) {
        return name;
    }

    void handleSearch() {
        searchTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                tabsListView.getSelectionModel().selectFirst();
                if (t1.isEmpty() || t1.isBlank()) {
                    showAllItems();
                } else {
                    ArrayList<Product> searchProducts = new ArrayList<>();
                    for (Product product : Main.store.getProducts()) {
                        if (product.getName().toLowerCase().contains(t1.toLowerCase())) {
                            searchProducts.add(product);
                            continue;
                        }
                        if (product.getCategory().name().toLowerCase().contains(t1.toLowerCase())) {
                            searchProducts.add(product);
                            continue;
                        }
                        if (product.getId().contains(t1)) {
                            searchProducts.add(product);
                            continue;
                        }
                    }
                    showSearchItems(searchProducts);
                }
            }
        });
    }

    private void showAllItems() {
        this.productList = FXCollections.observableArrayList(Main.store.getProducts());
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productId.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
        productCategory.setCellValueFactory(new PropertyValueFactory<Product, Product.Category>("category"));
        productPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productQuantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        productSalePrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("salePrice"));
        productDiscount.setCellValueFactory(new PropertyValueFactory<Product, Integer>("percentage"));
        productTable.setItems(this.productList);
    }

    private void showFoodItems() {
        this.productList = FXCollections.observableArrayList(Main.store.getAllFoodProducts());
        productTable.setItems(this.productList);
    }

    private void showElectronicItems() {
        this.productList = FXCollections.observableArrayList(Main.store.getAllElectronicProducts());
        productTable.setItems(this.productList);
    }

    private void showClothingItems() {
        this.productList = FXCollections.observableArrayList(Main.store.getAllClothingProducts());
        productTable.setItems(this.productList);
    }

    private void showSearchItems(ArrayList<Product> products) {
        this.productList = FXCollections.observableArrayList(products);
        productTable.setItems(this.productList);
    }
}
