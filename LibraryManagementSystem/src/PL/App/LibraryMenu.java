package PL.App;

import DAL.models.Book;
import PL.controller.BookController;
import PL.controller.LoanController;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private final BookController bookController;
    private final LoanController loanController;
    private final Scanner sc = new Scanner(System.in);

    public LibraryMenu(BookController bookController, LoanController loanController) {
        this.bookController = bookController;
        this.loanController = loanController;
    }

    public void start() {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            try {
                choice = Integer.parseInt(sc.nextLine());
                handle(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
    }

    private void printMenu() {
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add book");
        System.out.println("2. Show all books");
        System.out.println("3. Search book");
        System.out.println("4. Edit book");
        System.out.println("5. Delete book");
        System.out.println("6. Borrow book");
        System.out.println("7. Return book");
        System.out.println("8. Show available books");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    private void handle(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                printBooks(bookController.getAllBooks());
                break;
            case 3:
                System.out.print("Title: ");
                printBooks(bookController.searchBooks(sc.nextLine()));
                break;
            case 4:
                editBook();
                break;
            case 5:
                System.out.print("ISBN: ");
                System.out.println(bookController.deleteBook(sc.nextLine()));
                break;
            case 6:
                borrowBook();
                break;
            case 7:
                System.out.print("ISBN: ");
                System.out.println(loanController.returnBook(sc.nextLine()));
                break;
            case 8:
                printBooks(bookController.getAvailableBooks());
                break;
            case 0:
                break;
            default:
                System.out.println("Unknown option");
        }
    }

    private void addBook() {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.println(bookController.addBook(title, author, isbn, year));
    }

    private void editBook() {
        System.out.print("ISBN of the book: ");
        String isbn = sc.nextLine();
        System.out.print("New title: ");
        String title = sc.nextLine();
        System.out.print("New author: ");
        String author = sc.nextLine();
        System.out.print("New year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.println(bookController.editBook(isbn, title, author, year));
    }

    private void borrowBook() {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Student ID: ");
        int studentId = Integer.parseInt(sc.nextLine());

        System.out.println(loanController.borrowBook(isbn, studentId));
    }

    private void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found");
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
}