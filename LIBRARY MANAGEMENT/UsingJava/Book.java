package UsingJava;
public class Book {

    private int bookId;
    private String title;
    private String author;
    private int copies;

    public Book(int bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return copies > 0;
    }

    public void borrow() {
        if (!isAvailable()) {
            throw new IllegalStateException("No copies available");
        }
        copies--;
    }

    public void returnBook() {
        copies++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopies() {
        return copies;
    }
}