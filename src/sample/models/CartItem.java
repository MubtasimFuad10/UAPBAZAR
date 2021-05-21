package sample.models;


import java.text.DecimalFormat;

public class CartItem extends Product {
    Product product;
    int quantity;
    double totalPrice;

    public CartItem(Product product, int quantity) {
        super(product.name, product.category, product.price, product.quantity, product.percentage);
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

    public void increaseQuantity(int increaseBy) {
        if (this.quantity + increaseBy <= product.getQuantity())
            this.quantity += increaseBy;
        else
            this.quantity = product.quantity;
        updateTotalPrice();
    }

    public void decreaseQuantity(int decreaseBy) {
        this.quantity -= decreaseBy;
        updateTotalPrice();
    }

    void updateTotalPrice() {
        this.totalPrice = Double.parseDouble(new DecimalFormat("#.00").format(this.product.getSalePrice() * this.quantity));
    }

    public double getTotalPrice() {
        updateTotalPrice();
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }


}
