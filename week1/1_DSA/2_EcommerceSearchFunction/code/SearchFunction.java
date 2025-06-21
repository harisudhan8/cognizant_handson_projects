import java.util.Arrays;

class ProductSearch {
    int productId;
    String productName;
    String category;

    ProductSearch(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

public class SearchFunction {
    public static int linearSearch(ProductSearch[] arr, String name) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].productName.equalsIgnoreCase(name)) return i;
        }
        return -1;
    }

    public static int binarySearch(ProductSearch[] arr, String name) {
        Arrays.sort(arr, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = arr[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return mid;
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ProductSearch[] products = {
            new ProductSearch(1, "Laptop", "Electronics"),
            new ProductSearch(2, "Mobile", "Electronics"),
            new ProductSearch(3, "Shoes", "Fashion")
        };

        int index = linearSearch(products, "Mobile");
        System.out.println("Linear Search: Found at index " + index);

        int index2 = binarySearch(products, "Mobile");
        System.out.println("Binary Search: Found at index " + index2);
    }
}
