package JavaProject;


public class Clothing extends Product {// make this a subclass of Product
    private String brand;
    private SubCategory subCategory; // Can use String as well
    private Size size; // Can avoid enum if you want

    // constructor
    public Clothing(String name, String id, int quantity, String brand, SubCategory subCategory, Size size,
                    double price) {
        super(name, id, Category.Cloth, quantity, price);
        this.brand = brand;
        this.subCategory = subCategory;
        this.size = size;
    }

    // getter/setter

    public String getBrand() {
        return this.brand;
    }

    public SubCategory getSubCategory() {
        return this.subCategory;
    }

    public Size getSize() {
        return this.size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    // Override the putOnSale method
    // This method will put an item on sale and also set the sale percentage
    // The item id ans sale percentage will be decided by the admin.
    @Override
    public void putOnSale(Object id, int percentage) {
        if (this.getId().equals(id)) {
            this.setOnSale(true);
            this.setSalePercent(percentage);

        }
    }

    // This details method is for admin user. Admin should be able to see
    // everything.
    // Call details method of parent class and add other info specific to this class
    public String details() {
        return super.details() + "SubCategory =" + this.subCategory + "Size=" + this.size + " Brand= " + this.brand;
    }

}

enum SubCategory {
    MEN, WOMEN, KIDS, GIRLS
}

enum Size {
    SMALL, MEDIUM, LARGE, XL, XXL
}

