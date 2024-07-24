import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static Map<Student, Double> overallGrades = new HashMap<>();

    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public static void enrollStudent(Student student, Course course) {
        student.enrollCourse(course);
    }

    public static void assignGrade(Student student, Course course, String grade) {
        student.assignGrade(course, grade);
    }

    public static void calculateOverallGrade(Student student) {
        Map<Course, String> enrolledCourses = student.getEnrolledCourses();
        double totalGradePoints = 0;
        int totalCourses = 0;

        for (Map.Entry<Course, String> entry : enrolledCourses.entrySet()) {
            String grade = entry.getValue();
            if (grade != null) {
                totalGradePoints += getGradePoint(grade);
                totalCourses++;
            }
        }

        double overallGrade = (totalCourses == 0) ? 0 : totalGradePoints / totalCourses;
        overallGrades.put(student, overallGrade);
    }

    private static double getGradePoint(String grade) {
        switch (grade.toUpperCase()) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }
}