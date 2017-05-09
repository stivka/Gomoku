package ee.ttu.java.university;

import java.util.List;

/**
 * Created by stkapt on 09.05.2017.
 */
public class Course {
    private String name;
    private List<Student> Students();

    public Course(String name) {
        this.name = name;
    }
    public void enrol(Student student) {

    }
    public List<Student>getStudents() {

        return null;
    }
    public static void main(String[] args) {
        Course mata = new Course("Mata");
        mata.enrol(aavo);

    }
}
