import java.util.ArrayList;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void start() {

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n--- Menu ---");
            System.out.println("1 Add Book");
            System.out.println("2 Borrow Book");
            System.out.println("3 Return Book");
            System.out.println("4 Show Books");
            System.out.println("5 Exit");
            System.out.print("Enter choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input");
                input.nextLine();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                addBook();
            } 
            else if (choice == 2) {
                borrowBook();
            } 
            else if (choice == 3) {
                returnBook();
            } 
            else if (choice == 4) {
                showBooks();
            } 
            else if (choice == 5) {
                System.out.println("Done");
            } 
            else {
                System.out.println("Try again");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter title: ");
        String title = input.nextLine();

        Book b = new Book(title);
        books.add(b);

        System.out.println("Book added");
    }

    private void borrowBook() {
        System.out.print("Borrow which book: ");
        String title = input.nextLine();

        boolean found = false;

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);

            if (b.getTitle().equalsIgnoreCase(title)) {
                b.borrowBook();
                found = true;
            }
        }

        if (found == false) {
            System.out.println("No match");
        }
    }

    private void returnBook() {
        System.out.print("Return which book: ");
        String title = input.nextLine();

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                found = true;
            }
        }

        if (found == false) {
            System.out.println("No match");
        }
    }

    private void showBooks() {
        System.out.println("\nBooks available:");

        boolean any = false;

        for (Book book : books) {
            if (book.isBorrowed() == false) {
                System.out.println("- " + book.getTitle());
                any = true;
            }
        }

        if (any == false) {
            System.out.println("Nothing here");
        }
    }
}
