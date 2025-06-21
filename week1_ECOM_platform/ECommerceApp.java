import java.util.*;

public class ECommerceApp {

    // Product Class
    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return id + ". " + name + " - ₹" + price;
        }
    }

    // User Class
    static class User {
        String username;
        Cart cart;

        User(String username) {
            this.username = username;
            this.cart = new Cart();
        }
    }

    // Cart Class
    static class Cart {
        List<Product> items = new ArrayList<>();

        void addProduct(Product p) {
            items.add(p);
            System.out.println(p.name + " added to cart.");
        }

        void viewCart() {
            if (items.isEmpty()) {
                System.out.println("Cart is empty.");
                return;
            }
            System.out.println("Items in your cart:");
            double total = 0;
            for (Product p : items) {
                System.out.println(p);
                total += p.price;
            }
            System.out.println("Total: ₹" + total);
        }
    }

    // Method to search products by name
    static void searchProducts(List<Product> products, String keyword) {
        System.out.println("Search results for: \"" + keyword + "\"");
        boolean found = false;
        for (Product p : products) {
            if (p.name.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found.");
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample product list
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Mobile", 15000));
        products.add(new Product(3, "Headphones", 2000));
        products.add(new Product(4, "Smart Watch", 3500));
        products.add(new Product(5, "Bluetooth Speaker", 2500));

        System.out.print("Enter your name to register: ");
        String name = sc.nextLine();
        User user = new User(name);
        System.out.println("Welcome, " + user.username + "!");

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View All Products");
            System.out.println("2. Search Products");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Enter product name to search: ");
                    String keyword = sc.nextLine();
                    searchProducts(products, keyword);
                    break;
                case 3:
                    System.out.print("Enter Product ID to add to cart: ");
                    int pid = sc.nextInt();
                    if (pid >= 1 && pid <= products.size()) {
                        user.cart.addProduct(products.get(pid - 1));
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
                    break;
                case 4:
                    user.cart.viewCart();
                    break;
                case 5:
                    System.out.println("Thank you for shopping with us!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
