package JavaProject;


import java.time.*;

public class FoodItem extends Product { // make this a subclass of Product
    private LocalDate mfgDate,    expirationDate;

    // constructor
    public FoodItem(String name, String id, int quantity, LocalDate mfgDate, LocalDate expirationDate, double price) {
        super(name, id, Category.Food, quantity, price);
        this.mfgDate = mfgDate;
        this.expirationDate = expirationDate;
    }

    // getter
    public LocalDate getMfgDate() {
        return mfgDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    // setter

    public void setMfgDate(LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // This method will put an item on sale if the item expires
    // within next few days which will be decided by the admin.
    @Override
    public void putOnSale(Object criterion, int p) {
        int days = (int) criterion;
        int rem_days = this.getExpirationDate().compareTo(LocalDate.now());
        if (rem_days >= 0)

        {
            if(rem_days<=days)
            {
                this.setOnSale(true);
                this.setSalePercent(p);
            }

        } else {
            System.out.println("Product is expired.\n");
        }

    }

    // This details method is for admin user. Admin should be able to see
    // everything.
    public String details() {
        return super.details()+"Expire Date ="+this.expirationDate ;
    }
}
