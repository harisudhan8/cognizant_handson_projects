import java.util.HashMap;
import java.util.Scanner;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " - " + productName + " | Qty: " + quantity + " | Price: ₹" + price;
    }
}

public class Inventory {
    static HashMap<String, Product> inventory = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product p = new Product(id, name, qty, price);
        inventory.put(id, p);
        System.out.println("Product added successfully!\n");
    }

    public static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        String id = scanner.nextLine();

        if (!inventory.containsKey(id)) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product p = inventory.get(id);
        p.quantity = qty;
        p.price = price;

        System.out.println("Product updated successfully!\n");
    }

    public static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = scanner.nextLine();

        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully!\n");
        } else {
            System.out.println("Product not found.\n");
        }
    }

    public static void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.\n");
            return;
        }

        System.out.println("Current Inventory:");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("==== Inventory Management System ====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    updateProduct();
                    break;
                case "3":
                    deleteProduct();
                    break;
                case "4":
                    showInventory();
                    break;
                case "5":
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}
