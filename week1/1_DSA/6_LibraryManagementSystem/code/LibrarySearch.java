import java.util.*;

class Book {
    int bookId;
    String title, author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - \"" + title + "\" by " + author;
    }
}

public class LibrarySearch {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Alchemist", "Paulo Coelho"),
            new Book(2, "Clean Code", "Robert C. Martin"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "To Kill a Mockingbird", "Harper Lee")
        };

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase())); // for binary search

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title to search: ");
        String target = sc.nextLine();

        System.out.println("\nLinear Search:");
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(target)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
