package PL.App;

import BLL.BookService;
import BLL.LoanService;
import DAL.models.Student;
import DAL.repos.BookRepo;
import DAL.repos.LoanRepo;
import DAL.repos.StudentRepo;
import PL.controller.BookController;
import PL.controller.LoanController;

public class Main {
    public static void main(String[] args) {
        BookRepo bookRepo = new BookRepo();
        StudentRepo studentRepo = new StudentRepo();
        LoanRepo loanRepo = new LoanRepo();

        studentRepo.save(new Student(1, "Maria"));
        studentRepo.save(new Student(2, "Ivan"));
        studentRepo.save(new Student(3, "Alex"));

        BookService bookService = new BookService(bookRepo);
        LoanService loanService = new LoanService(bookRepo, studentRepo, loanRepo);

        BookController bookController = new BookController(bookService);
        LoanController loanController = new LoanController(loanService);

        LibraryMenu menu = new LibraryMenu(bookController, loanController);
        menu.start();
    }
}