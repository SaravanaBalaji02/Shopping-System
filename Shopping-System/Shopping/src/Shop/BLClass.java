package Shop;

import java.util.HashMap;

public class BLClass {
    private HashMap<String, Double> productMap = new HashMap<>();

    public void addProduct(String productName, double productPrice) {
        productMap.put(productName, productPrice);
    }

    public void buyProduct(String productName) {
        if (productMap.containsKey(productName)) {
            System.out.println("Product purchased: " + productName + " for ₹" + productMap.get(productName));
        } else {
            System.out.println("Product not found in the catalog.");
        }
    }

    public void displayAllProducts() {
        System.out.println("Available Products:");
        for (String productName : productMap.keySet()) {
            System.out.println(productName + ": ₹" + productMap.get(productName));
        }
    }
}
