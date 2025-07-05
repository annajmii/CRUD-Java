import java.util.*;

public class BookService {
    private final List<Book> books = new ArrayList<>();

    // Create
    public void addBook(Book book) {
        books.add(book);
    }

    // Read
    public List<Book> getAllBooks() {
        return books;
    }

    // Update
    public boolean updateBook(int id, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                return true;
            }
        }
        return false;
    }

    // Delete
    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}