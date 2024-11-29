package Shop;

import java.util.HashMap;
import java.util.Scanner;

public class MainApp1 {
    static HashMap<String, String> userMap = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static BLClass bl = new BLClass();
    static String loggedInUser = null;

    public static void main(String[] args) {
        // Predefined users and products
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        bl.addProduct("Laptop", 50000);
        bl.addProduct("Phone", 20000);
        bl.addProduct("Headphones", 2000);

        boolean status = false;
        while (!status) {
            displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> buyProduct();
                case 4 -> bl.displayAllProducts();
                case 5 -> logout();
                case 6 -> {
                    System.out.println("Exiting the application. Thank you!");
                    status = true;
                }
                default -> System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=================================");
        System.out.println("1. Log in");
        System.out.println("2. Register");
        System.out.println("3. Buy product");
        System.out.println("4. Display all products");
        System.out.println("5. Sign out");
        System.out.println("6. Exit");
        System.out.println("==================================");
        System.out.print("Enter your choice: ");
    }

    private static void login() {
        if (loggedInUser != null) {
            System.out.println("You are already logged in as: " + loggedInUser);
            return;
        }
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter password: ");
        String password = sc.next();

        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            loggedInUser = username;
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private static void register() {
        System.out.print("Enter new username: ");
        String username = sc.next();
        if (userMap.containsKey(username)) {
            System.out.println("Username already exists. Try another.");
            return;
        }
        System.out.print("Enter new password: ");
        String password = sc.next();
        userMap.put(username, password);
        System.out.println("Registration successful!");
    }

    private static void buyProduct() {
        if (loggedInUser == null) {
            System.out.println("You need to log in first.");
            return;
        }
        System.out.print("Enter product name to buy: ");
        String productName = sc.next();
        bl.buyProduct(productName);
    }

    private static void logout() {
        if (loggedInUser != null) {
            System.out.println("Logged out. Goodbye, " + loggedInUser + "!");
            loggedInUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }
}
