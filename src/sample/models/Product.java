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
    public Product(String name, Category category, Double price){
        this.name = name;
        this.category = category;
        this.price = price;
        this.id = (Math.random() + "").substring(2, 8);
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
}
