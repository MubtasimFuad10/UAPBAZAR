package sample.models;

import java.util.UUID;

public class Product {
    public enum Category {
        Food,
        Electronic,
        Clothing,
    }

    String id;
    String name;
    Category category;
    Double price;
    Double salePrice;
    int quantity;
    boolean inStock;

    public Product(String name, Category category, Double price, int quantity, Double salePrice) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.id = (Math.random() + "").substring(2, 8);
        this.salePrice = salePrice;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }
}
