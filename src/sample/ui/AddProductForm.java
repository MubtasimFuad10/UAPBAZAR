package sample.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.Main;
import sample.models.ClothingProduct;
import sample.models.ElectronicProduct;
import sample.models.FoodProduct;
import sample.models.Product;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;


public class AddProductForm {
    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQuantity;

    @FXML
    private ComboBox<String> productCategory;

    @FXML
    private TextField productDiscount;

    @FXML
    private TextField productSalePrice;

    @FXML
    private GridPane fpGroup;

    @FXML
    private DatePicker fpExpirationDate;

    @FXML
    private ComboBox<String> fpCategory;

    @FXML
    private GridPane epGroup;

    @FXML
    private ComboBox<String> epCategory;

    @FXML
    private GridPane cpGroup;

    @FXML
    private ComboBox<String> cpCategory;

    @FXML
    private Button addProductButton;

    ObservableList<String> categorys = FXCollections.observableArrayList();
    ObservableList<String> fpCategorys = FXCollections.observableArrayList();
    ObservableList<String> epCategorys = FXCollections.observableArrayList();
    ObservableList<String> cpCategorys = FXCollections.observableArrayList();

    Product.Category pc = Product.Category.values()[0];

    @FXML
    private void initialize() {
        for (Product.Category value : Product.Category.values()) {
            categorys.add(value.name());
        }
        for (FoodProduct.SubCategory value : FoodProduct.SubCategory.values()) {
            fpCategorys.add(value.name());
        }
        for (ElectronicProduct.SubCategory value : ElectronicProduct.SubCategory.values()) {
            epCategorys.add(value.name());
        }
        for (ClothingProduct.SubCategory value : ClothingProduct.SubCategory.values()) {
            cpCategorys.add(value.name());
        }
        productCategory.setItems(categorys);
        epCategory.setItems(epCategorys);
        fpCategory.setItems(fpCategorys);
        cpCategory.setItems(cpCategorys);
        productCategory.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (s == null || !s.equals(t1)) {
                    productCategoryChange(t1);
                }
            }
        });
        addProductButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addProduct();
            }
        });
        initValues();
        productPrice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (s == null || !s.equals(t1)) {
                    updateSalePrice();
                }
            }
        });
        productDiscount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (s == null || !s.equals(t1)) {
                    if (Integer.parseInt(t1) > 100) {
                        productDiscount.setText("100");
                    }
                    if (t1.isBlank() || t1.isEmpty() || Integer.parseInt(t1) < 0) {
                        productDiscount.setText("0");
                    }
                    updateSalePrice();
                }
            }
        });
        updateSalePrice();
    }

    void updateSalePrice() {
        int discount = productDiscount.getText().isEmpty() ? 0 : Integer.parseInt(productDiscount.getText());
        Double price = productPrice.getText().isEmpty() ? 0.0 : Double.parseDouble(productPrice.getText());
        Double salePrice = price - (price * discount) / 100;
        productSalePrice.setText(salePrice.toString());
    }

    void initValues() {
        productSalePrice.setDisable(true);
        productName.setText("");
        pc = Product.Category.values()[0];
        productCategory.setValue(pc.name());
        productQuantity.setText("0");
        productPrice.setText("0");
        productSalePrice.setText("0");
        productDiscount.setText("0");
        productCategoryChange(pc.name());
        cpCategory.setValue(cpCategorys.get(0));
        fpCategory.setValue(fpCategorys.get(0));
        epCategory.setValue(epCategorys.get(0));
        fpExpirationDate.setValue(LocalDate.now());
    }

    void productCategoryChange(String name) {
        pc = Product.Category.valueOf(name);
        fpGroup.setVisible(pc == Product.Category.Food);
        epGroup.setVisible(pc == Product.Category.Electronic);
        cpGroup.setVisible(pc == Product.Category.Clothing);
    }

    void addProduct() {
        String name = productName.getText();
        Double price = productPrice.getText().isEmpty() ? 0.0 : Double.parseDouble(productPrice.getText());
        int quantity = productQuantity.getText().isEmpty() ? 0 : Integer.parseInt(productQuantity.getText());
        int percentage = productDiscount.getText().isEmpty() ? 0 : Integer.parseInt(productDiscount.getText());

        if (pc == Product.Category.Food) {
            Main.store.addFoodProduct(name, price, fpExpirationDate.getValue(), FoodProduct.SubCategory.valueOf(fpCategory.getValue()), quantity, percentage);
        } else if (pc == Product.Category.Electronic) {
            Main.store.addElectronicProduct(name, price, ElectronicProduct.SubCategory.valueOf(epCategory.getValue()), quantity, percentage);
        } else if (pc == Product.Category.Clothing) {
            Main.store.addClothingProduct(name, price, ClothingProduct.SubCategory.valueOf(cpCategory.getValue()), quantity, percentage);
        }
        initValues();
    }
}
