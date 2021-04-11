package JavaProject;



public abstract class Product implements Cloneable {
    private String name, id;
    private Category category;
    private int quantity;
    private double price;
    private boolean onSale;
    private int salePercent;

    // constructor
    public Product(String name, String id, Category category, int quantity, double price) {
        super();
        this.name = name;
        this.id = id;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // getter
    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    // setter

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    // END getter setter

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double totalPrice(int amt) {
        return amt * price;
    }

    public double salePrice(int amt) {
        if (this.isOnSale()) {
            return amt * price * ((100 - salePercent) / 100.0);
        } else {
            return totalPrice(amt);
        }
    }

    // abstract method
    public abstract void putOnSale(Object criterion, int percentage);

    // To show the summary or customer view

    @Override
    public String toString() {
        if (!onSale)
            return String.format("%s(%s)-%.1f tk", name, id, price);
        else
            return String.format("%s(%s)-On Sale-%.1f tk(Original Price:%d)", name, id, price, salePrice(1));

    }

    // This is for showing the details for admin

    public String details() {
        return "name=" + name + "\tid=" + id + "\tcategory=" + category + "\tquantity=" + quantity + "\tprice=" + price
                + "\tonSale=" + onSale + "\tsalePercent=" + salePercent;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

enum Category {
    Food, Cloth, Electronics
}

//public abstract class Product {
//	private String name, id, category;
//	private double price;
//	private int quantity;
//	private boolean isOnSale;
//
//	public Product(String name, String category, double price, int quantity) {
//		super();
//		this.name = name;
//		this.category = category;
//		this.price = price;
//		this.quantity = quantity;
////		this.isOnSale=isOnSale;
//
//	}
//
//	abstract double salePrice(Object criteria, int amt);
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public boolean isOnSale() {
//		return isOnSale;
//	}
//
//	public void setOnSale(boolean isOnSale) {
//		this.isOnSale = isOnSale;
//	}
//
//	public double totalPrice(int amt) {
//		return amt * this.price;
//	}
//
//}

