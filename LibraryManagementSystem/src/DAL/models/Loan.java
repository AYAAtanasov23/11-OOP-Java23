package DAL.models;

public class Loan {
    private Book book;
    private Student student;
    private boolean returned;

    public Loan(Book b, Student s) {
        book = b;
        student = s;
        returned = false;
    }

    public Book getBook() {
        return book;
    }
    public Student getStudent() {
        return student;
    }
    public boolean isReturned() {
        return returned;
    }
    public void setReturned(boolean r) {
        returned = r;
    }
}
