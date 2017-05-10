package ee.ttu.java.university;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stkapt on 09.05.2017.
 */
public class Student {

    private String name;

    private static List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;


    }
    public List<Course> getCourses() {
        return courses;
    }
    public static void main(String[] args){
        Student aavo = new Student("Aavo");
    }
}
