package UsingJava;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int userId;
    private String name;
    private String role;
    private List<Integer> borrowedBooks;

    public User(int userId, String name, String role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public boolean isAdmin() {
        return role.equals("ADMIN");
    }

    public void borrowBook(int bookId) {
        if (borrowedBooks.contains(bookId)) {
            throw new IllegalStateException("Book already borrowed");
        }
        borrowedBooks.add(bookId);
    }

    public void returnBook(int bookId) {
        borrowedBooks.remove(Integer.valueOf(bookId));
    }
}