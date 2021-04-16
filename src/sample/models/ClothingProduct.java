package sample.models;

public class ClothingProduct extends Product{
    public enum SubCategory {
        Casual,
        Sports,
        Pant,
        TShirt,
        Tie,
        Shirt,
        Other,
    }
    public enum Size {
        S,
        M,
        L,
        XL,
        XXL,
    }
    SubCategory subCategory;
    Size size;

    public ClothingProduct(String name, Double price, SubCategory subCategory, int quantity, Double salePrice){
        super(name, Category.Clothing, price, quantity, salePrice);
        this.subCategory = subCategory;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Size getSize() {

        return size;
    }

    public void setSize(Size size) {

        this.size = size;
    }

    public String getSubCategoryName(){

        return this.subCategory.name();
    }
}
