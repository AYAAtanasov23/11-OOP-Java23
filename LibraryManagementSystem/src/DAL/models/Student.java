package DAL.models;

public class Student {
    private int id;
    private String name;

    public Student(int i, String n) {
        id = i;
        name = n;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
