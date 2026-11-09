package PL.controller;

import BLL.LoanService;

public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    public String borrowBook(String isbn, int studentId) {
        try {
            loanService.borrowBook(isbn, studentId);
            return "Book borrowed";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }

    public String returnBook(String isbn) {
        try {
            loanService.returnBook(isbn);
            return "Book returned";
        } catch (IllegalArgumentException e) {
            return "Error: " + e.getMessage();
        }
    }
}