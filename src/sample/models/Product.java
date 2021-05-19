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
    boolean inStock;
    int quantity;
    double salePrice;
    int percentage;

    public Product(String name, Category category, Double price, int quantity, int percentage){
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.id = (Math.random() + "").substring(2, 8);
        this.setPercentage(percentage);
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

    public double getSalePrice() {
        return salePrice;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
        this.salePrice = price - (price * percentage) / 100;
    }
}
