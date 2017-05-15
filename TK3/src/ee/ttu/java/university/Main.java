package ee.ttu.java.university;

/**
 * Created by Stiv on 10/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        Student aavo = new Student("Aavo");
        Student marko = new Student("Marko");
        Student meelis = new Student("Meelis");

        Course java = new Course("Java");
        Course python = new Course("Python");

        aavo.addCourse(java);
        System.out.println(aavo.getCourses());
        aavo.removeCourse(java);
        System.out.println(java.getStudents());

    }
}
