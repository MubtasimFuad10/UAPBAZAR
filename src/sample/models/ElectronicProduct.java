package sample.models;

public class ElectronicProduct extends Product{
    public enum SubCategory {
        Computer,
        Refrigerator,
        Ac,
        Blender,
        Mobile,
        Laptop,
        Other,
    }

    SubCategory subCategory;

    public ElectronicProduct(String name, Double price, SubCategory subCategory, int quantity, int percentage){
        super(name, Category.Electronic, price, quantity, percentage);
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
}
