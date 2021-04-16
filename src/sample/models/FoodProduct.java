package sample.models;

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

    Date expirationDate;
    SubCategory subCategory;

    public FoodProduct(String name, Double price, Date expirationDate, SubCategory subCategory, int quantity, Double salePrice){
        super(name, Category.Food, price, quantity,salePrice);
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
