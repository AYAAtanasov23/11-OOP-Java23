package BLL;

import DAL.models.Book;
import DAL.repos.BookRepo;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(Book book) {
        if(book.getTitle() == null || book.getTitle().isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if(bookRepo.findByIsbn(book.getIsbn()) != null) {
            throw new IllegalArgumentException("Book already exists");
        }
        bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public List<Book> searchByTitle(String text) {
        return bookRepo.findByTitle(text);
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book b : bookRepo.findAll()) {
            if(b.isAvailable()) {
                result.add(b);
            }
        }
        return result;
    }

    public void editBook(String isbn, String title, String author, int year) {
        Book book = bookRepo.findByIsbn(isbn);
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if(title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
    }

    public void deleteBook(String isbn) {
        Book book = bookRepo.findByIsbn(isbn);
        if(book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if(!book.isAvailable()) {
            throw new IllegalArgumentException("Cannot delete a borrowed book");
        }
        bookRepo.delete(book);
    }
}
