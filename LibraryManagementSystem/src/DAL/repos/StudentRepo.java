package DAL.repos;

import DAL.models.Student;
import java.util.List;
import java.util.ArrayList;

public class StudentRepo {
    private final List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return new  ArrayList<>(students);
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
