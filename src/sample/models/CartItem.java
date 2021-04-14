package sample.models;

public class CartItem extends Product {
    Product product;
    int quantity;
    double totalPrice;

    public CartItem(Product product, int quantity){
        super(product.name, product.category, product.price);
        this.product = product;
        this.quantity = quantity;
        updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        updateTotalPrice();
    }

    public void increaseQuantity(int increaseBy){
        this.quantity += increaseBy;
        updateTotalPrice();
    }

    public void decreaseQuantity(int decreaseBy){
        this.quantity -= decreaseBy;
        updateTotalPrice();
    }

    void updateTotalPrice(){
        this.totalPrice = this.product.getPrice() * this.quantity;
    }

    public double getTotalPrice() {
        updateTotalPrice();
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }
}
