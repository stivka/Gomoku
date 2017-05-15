package ee.ttu.java.university;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stkapt on 09.05.2017.
 */
public class Course {
    private String name;

    private List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public void enrol(Student student) {
        students.add(student);
        student.addCourse(this);
    }
    public List<Student> getStudents() {
        return students;
    }
    public String toString() {
        return this.name;
    }
    public void removeCourse(Student student) {
        students.remove(student);
        student.removeCourse(this);
    }
}
