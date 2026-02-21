package UsingJava;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    private User findUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public boolean borrowBook(int userId, int bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user == null || book == null) {
            return false;
        }

        if (!book.isAvailable()) {
            return false;
        }

        book.borrow();
        user.borrowBook(bookId);
        return true;
    }

    public boolean returnBook(int userId, int bookId) {
        User user = findUser(userId);
        Book book = findBook(bookId);

        if (user == null || book == null) {
            return false;
        }

        user.returnBook(bookId);
        book.returnBook();
        return true;
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
            return;
        }
        System.out.println("\n--- Available Books ---");
        for (Book book : books) {
            System.out.println(
                "ID: " + book.getBookId() +
                " | Title: " + book.getTitle() +
                " | Author: " + book.getAuthor() +
                " | Copies: " + book.getCopies()
            );
        }
    }
}