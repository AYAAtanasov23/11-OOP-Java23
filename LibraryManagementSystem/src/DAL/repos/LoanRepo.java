package DAL.repos;

import DAL.models.Loan;
import java.util.ArrayList;
import java.util.List;

public class LoanRepo {
    private final List<Loan> loans = new ArrayList<>();

    public void save(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    public Loan findActiveByIsbn(String isbn) {
        for (Loan loan : loans) {
            if(!loan.isReturned() && loan.getBook().getIsbn().equals(isbn)) {
                return loan;
            }
        }
        return null;
    }

    public int countActiveByStudent(int studentId) {
        int count = 0;
        for (Loan loan : loans) {
            if(!loan.isReturned() && loan.getStudent().getId() == studentId) {
                count++;
            }
        }
        return count;
    }
}
