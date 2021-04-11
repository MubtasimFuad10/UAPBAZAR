package JavaProject;


import java.util.*;

import JavaProject.Electronics.ElectCategory;

import java.time.LocalDate;

public class OnlineStore {

    public static void main(String[] args) {
        Store store = new Store("AmazonBD");
        Scanner input = new Scanner(System.in);

        while (true) {
            boolean isAdmin = false;
            boolean flag = true;
            System.out.println("Enter 1:Admin, 2:Customer, 0:Exit.");
            int n = input.nextInt();
            if (n == 0)
                break;
            if (n == 1)
                isAdmin = true;

            if (isAdmin) {
                while (flag) {
                    System.out.println(
                            "Enter 1:Add item to store, 2:Put an item on sale, 3:View all items, 4:View items if a category 0:Exit Admin.");
                    int first = input.nextInt();
                    switch (first) {
                        case 1:
                            System.out.println("Enter 1:FoodItem, 2:Clothing, 3:Electronics.");
                            int second = input.nextInt();
                            switch (second) {
                                case 1:
                                    System.out.println("Enter Product name,id,quantity,price,expireWithin(days).");
                                    String name = input.next();
                                    String id = input.next();
                                    int quantity = input.nextInt();
                                    double price = input.nextDouble();
                                    int a = input.nextInt();
                                    LocalDate mfg = LocalDate.now();
                                    LocalDate exp = mfg.plusDays(a);

                                    store.addProduct(name, id, quantity, mfg, exp, price);
                                    break;
                                case 2:
                                    System.out.println("Enter name,id,price,brand,SubCategory,Size.");
                                    name = input.next();
                                    id = input.next();
                                    price = input.nextDouble();
                                    quantity = input.nextInt();
                                    String brand = input.next();
                                    int i;
                                    System.out.print("For SubCategory Enter-");
                                    i = 0;

                                    for (SubCategory s : SubCategory.values()) {
                                        i++;
                                        System.out.printf(i + ":" + s + " ");
                                    }
                                    System.out.println();

                                    i = input.nextInt();
                                    SubCategory subCategory = SubCategory.values()[i - 1];

                                    System.out.print("For Size Enter-");
                                    i = 0;
                                    for (Size s : Size.values()) {
                                        i++;
                                        System.out.printf(i + ":" + s + " ");
                                    }
                                    System.out.println();

                                    i = input.nextInt();
                                    Size size = Size.values()[i - 1];

                                    store.addProduct(name, id, quantity, brand, subCategory, size, price);
                                    break;
                                case 3:
                                    System.out.println("Enter name,id,quantity,price,manufacturer,subCategory.");
                                    name = input.next();
                                    id = input.next();
                                    quantity = input.nextInt();
                                    price = input.nextDouble();
                                    String manufacturer = input.next();
                                    System.out.print("For ElectCategory Enter-");
                                    i = 0;
                                    for (ElectCategory s : ElectCategory.values()) {
                                        i++;
                                        System.out.printf(i + ":" + s + " ");
                                    }
                                    System.out.println();

                                    i = input.nextInt();
                                    ElectCategory subCategory2 = ElectCategory.values()[i - 1];

                                    store.addProduct(name, id, quantity, manufacturer, subCategory2, price);
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Enter 1:FoodItem, 2:Clothing, 3:Electronics.");
                            int opS = input.nextInt();
                            switch (opS) {
                                case 1:
                                    System.out.println("Enter expireWithin, percentage");
                                    int expireWithin = input.nextInt();
                                    int percentage = input.nextInt();

                                    store.putOnSaleFood(expireWithin, percentage);
                                    break;
                                case 2:
                                    System.out.println("Enter id, percentage");
                                    String id = input.next();
                                    percentage = input.nextInt();

                                    store.putOnSaleCloth(id, percentage);

                                    break;
                                case 3:
                                    System.out.println("Enter id, percentage");
                                    id = input.next();
                                    percentage = input.nextInt();

                                    store.putOnSaleElectronic(id, percentage);

                                    break;
                            }
                            break;
                        case 3:
                            store.viewProducts(isAdmin);
                            break;
                        case 4:
                            System.out.println("Enter 1:FoodItem, 2:Clothing, 3:Electronics.");
                            int cat = input.nextInt();
                            Category category = Category.values()[cat - 1];

                            store.viewProductsAsAdmin(category);
                            break;
                        case 0:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter a valid input");
                            break;
                    }
                }
            } else {
                while (flag) {
                    System.out.println(
                            "Enter 1:View all items, 2:View items of a category, 3:Add items to cart, 4:Remove items from cart, 5:Edit item count in the cart, 6:Clear cart, 7:Pay bill, 0:Exit Customer.");
                    int op = input.nextInt();
                    switch (op) {
                        case 1:
                            store.viewProducts(isAdmin);
                            break;
                        case 2:
                            System.out.println("Enter 1:FoodItem, 2:Clothing, 3:Electronics.");
                            int cat = input.nextInt();
                            Category category = Category.values()[cat - 1];

                            store.viewProducts(category);
                            break;
                        case 3:
                            System.out.println("Enter id, amount.");
                            String id = input.next();
                            int amt = input.nextInt();

                            try {
                                store.addProductToCart(id, amt);
                            } catch (CloneNotSupportedException e) {

                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            System.out.println("Enter id.");
                            id = input.next();

                            store.removeProductFromCart(id);
                            break;
                        case 5:
                            System.out.println("Enter id and new amount.");
                            id = input.next();
                            amt = input.nextInt();

                            store.updateProductInCart(id, amt);
                            break;
                        case 6:
                            store.clearCart();
                            break;
                        case 7:
                            store.payBill();
                            break;
                        case 0:
                            flag = false;
                            break;
                        default:
                            System.out.println("Enter a valid input");
                            break;
                    }
                }
            }
        }
        System.out.println("Program Ended.");
        input.close();
    }

}

