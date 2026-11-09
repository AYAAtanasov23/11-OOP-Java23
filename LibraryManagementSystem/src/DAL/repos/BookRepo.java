package DAL.repos;

import DAL.models.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepo {
    private final List<Book> books = new ArrayList<>();

    public void save (Book book) {
        books.add(book);
    }
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Book findByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        return null;
    }

    public List<Book> findByTitle(String text) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(text.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }
    public void delete(Book book) {
        books.remove(book);
    }
}
