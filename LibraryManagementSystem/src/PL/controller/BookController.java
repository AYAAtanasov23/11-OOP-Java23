package PL.controller;

import BLL.BookService;
import DAL.models.Book;
import java.util.List;

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public String addBook(String title, String author, String isbn, int year) {
        try {
            bookService.addBook(new Book(title, author, isbn, year));
            return "Book added";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public List<Book> searchBooks(String title) {
        return bookService.searchByTitle(title);
    }

    public List<Book> getAvailableBooks() {
        return bookService.getAvailableBooks();
    }

    public String editBook(String isbn, String title, String author, int year) {
        try {
            bookService.editBook(isbn, title, author, year);
            return "Book updated";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String deleteBook(String isbn) {
        try {
            bookService.deleteBook(isbn);
            return "Book deleted";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}