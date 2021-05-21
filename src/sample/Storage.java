package sample;

import sample.models.ClothingProduct;
import sample.models.ElectronicProduct;
import sample.models.FoodProduct;
import sample.models.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    File myStorageFile;
    String data = "";

    public void createFile() {
        try {
            myStorageFile = new File("storage.txt");
            if (myStorageFile.createNewFile()) {
                System.out.println("File created: " + myStorageFile.getName());
            } else {
                System.out.println("File already exists.");
                getData();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void storeData() {
        data = "";
        try {
            FileWriter myWriter = new FileWriter(myStorageFile.getName());
            for (Product product : Main.store.getProducts()) {
                if (product.getCategory() == Product.Category.Food) {
                    storeFoodItem((FoodProduct) product);
                } else if (product.getCategory() == Product.Category.Clothing) {
                    storeClothItem((ClothingProduct) product);
                } else if (product.getCategory() == Product.Category.Electronic) {
                    storeElectronicItem((ElectronicProduct) product);
                }
            }
            myWriter.write(data);

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void getData() {
        try {
            Scanner myReader = new Scanner(myStorageFile);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            for (String product : data.split("~")) {
                if (product.equals("")) {
                    return;
                } else if (product.split("\\|")[0].equals(Product.Category.Food.name())) {
                    getFoodProduct(product);
                } else if (product.split("\\|")[0].equals(Product.Category.Electronic.name())) {
                    getElectronicProduct(product);
                } else if (product.split("\\|")[0].equals(Product.Category.Clothing.name())) {
                    getClothingProduct(product);
                }
            }
            Main.store.getProducts().forEach(product -> {
                System.out.println(product.getName());
            });
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void storeFoodItem(FoodProduct product) {
        data += product.getCategory().name() + "|";
        data += product.getId() + "|";
        data += product.getName() + "|";
        data += product.getPrice() + "|";
        data += product.getQuantity() + "|";
        data += product.getPercentage() + "|";
        data += product.getExpirationDate() + "|";
        data += product.getSubCategory().name() + "|";
        data += "~";
    }

    void storeElectronicItem(ElectronicProduct product) {
        data += product.getCategory().name() + "|";
        data += product.getId() + "|";
        data += product.getName() + "|";
        data += product.getPrice() + "|";
        data += product.getQuantity() + "|";
        data += product.getPercentage() + "|";
        data += product.getSubCategory().name() + "|";
        data += "~";
    }

    void storeClothItem(ClothingProduct product) {
        data += product.getCategory().name() + "|";
        data += product.getId() + "|";
        data += product.getName() + "|";
        data += product.getPrice() + "|";
        data += product.getQuantity() + "|";
        data += product.getPercentage() + "|";
        data += product.getSubCategory().name() + "|";
        data += "~";
    }

    void getFoodProduct(String data) {
        FoodProduct foodProduct;
        String[] items = data.split("\\|");
        FoodProduct.SubCategory subCategory = FoodProduct.SubCategory.valueOf(items[7]);
        foodProduct = new FoodProduct(items[2], Double.parseDouble(items[3]), LocalDate.parse(items[6]), subCategory, Integer.parseInt(items[4]), Integer.parseInt(items[5]));
        Main.store.addFoodProduct(foodProduct);
    }

    void getClothingProduct(String data) {
        ClothingProduct clothingProduct;
        String[] items = data.split("\\|");
        ClothingProduct.SubCategory subCategory = ClothingProduct.SubCategory.valueOf(items[6]);
        clothingProduct = new ClothingProduct(items[2], Double.parseDouble(items[3]), subCategory, Integer.parseInt(items[4]), Integer.parseInt(items[5]));
        Main.store.addClothingProduct(clothingProduct);
    }

    void getElectronicProduct(String data) {
        ElectronicProduct electronicProduct;
        String[] items = data.split("\\|");
        ElectronicProduct.SubCategory subCategory = ElectronicProduct.SubCategory.valueOf(items[6]);
        electronicProduct = new ElectronicProduct(items[2], Double.parseDouble(items[3]), subCategory, Integer.parseInt(items[4]), Integer.parseInt(items[5]));
        Main.store.addElectronicProduct(electronicProduct);
    }

}
