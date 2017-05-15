package ee.ttu.java.university;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stkapt on 09.05.2017.
 */
public class Student {

    private String name;

    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public String toString() {
        return name;
    }
    public void removeCourse(Course course) {
        courses.remove(course);
    }
}
