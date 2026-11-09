package BLL;

import DAL.models.Book;
import DAL.models.Loan;
import DAL.models.Student;
import DAL.repos.BookRepo;
import DAL.repos.LoanRepo;
import DAL.repos.StudentRepo;

public class LoanService {
    private final BookRepo bookRepository;
    private final StudentRepo studentRepository;
    private final LoanRepo loanRepository;

    public LoanService(BookRepo bookRepository, StudentRepo studentRepository,
                       LoanRepo loanRepository) {
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.loanRepository = loanRepository;
    }

    public void borrowBook(String isbn, int studentId) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        Student student = studentRepository.findById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Book is already borrowed");
        }
        if (loanRepository.countActiveByStudent(studentId) >= 3) {
            throw new IllegalArgumentException("Student already has 3 unreturned books");
        }

        loanRepository.save(new Loan(book, student));
        book.setAvailable(false);
    }

    public void returnBook(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        Loan loan = loanRepository.findActiveByIsbn(isbn);
        if (loan == null) {
            throw new IllegalArgumentException("This book is not borrowed");
        }

        loan.setReturned(true);
        book.setAvailable(true);
    }
}