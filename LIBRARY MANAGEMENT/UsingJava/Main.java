package UsingJava;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book(1, "Clean Code", "Robert Martin", 3));
        library.addBook(new Book(2, "Effective Java", "Joshua Bloch", 2));

        library.addUser(new User(101, "Dhruv", "ADMIN"));
        library.addUser(new User(102, "Alex", "MEMBER"));

        while (true) {
            System.out.println("----------------");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Show Books");
            System.out.println("4. Exit");

            System.out.print("Choose any option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("User ID: ");
                int uid = scanner.nextInt();
                System.out.print("Book ID: ");
                int bid = scanner.nextInt();

                if (library.borrowBook(uid, bid)) {
                    System.out.println("Book borrowed successfully");
                } else {
                    System.out.println("Borrow failed");
                }
            } 
            
            else if (choice == 2) {
                System.out.print("User ID: ");
                int uid = scanner.nextInt();
                System.out.print("Book ID: ");
                int bid = scanner.nextInt();

                if (library.returnBook(uid, bid)) {
                    System.out.println("Book returned successfully");
                } else {
                    System.out.println("Return failed");
                }
            } 
            
            else if (choice == 3) {
                library.showBooks();
            } 
            
            else if (choice == 4) {
                break;
            }
            
            else{
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}