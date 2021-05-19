package sample.models;

import java.time.LocalDate;
import java.util.Date;

public class FoodProduct extends Product {
    public enum SubCategory {
        Fruits,
        Vegetables,
        Spices,
        Meal,
        Snacks,
        Other
    }

    LocalDate expirationDate;
    SubCategory subCategory;

    public FoodProduct(String name, Double price, LocalDate expirationDate, SubCategory subCategory, int quantity, int percentage){
        super(name, Category.Food, price, quantity, percentage);
        this.expirationDate = expirationDate;
        this.subCategory = subCategory;
    }

    String getSubCategoryName(){
        return this.subCategory.name();
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
