import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;

    Book(String title) {
        this.title = title;
    }
}

public class Library {
    List<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void run() {
        while (true) {
            System.out.println("1. Add Book\n2. View Books\n3. Remove Book\n4. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.next();
        books.add(new Book(title));
        System.out.println("Book added successfully!");
    }

    void viewBooks() {
        for (Book book : books) {
            System.out.println(book.title);
        }
    }

    void removeBook() {
        System.out.print("Enter book title: ");
        String title = scanner.next();

        for (Book book : books) {
            if (book.title.equals(title)) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.run();
    }
}