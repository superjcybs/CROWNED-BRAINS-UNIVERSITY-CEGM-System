import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<Course, String> enrolledCourses; // Course and Grade

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Course, String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        if (enrolledCourses.containsKey(course)) {
            System.out.println("Student is already enrolled in this course.");
        } else {
            enrolledCourses.put(course, null);
            course.incrementEnrolledStudents();
        }
    }

    public void assignGrade(Course course, String grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }
}