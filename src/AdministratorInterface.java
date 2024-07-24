import java.util.Scanner;   //importing package for accepting user input

public class AdministratorInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the CROWNED BRAINS UNIVERSITY Course Enrollment and Grade Management System, What will you work on today?");
            System.out.println("1. Add a new course");
            System.out.println("2. Enroll a student in a course");
            System.out.println("3. Assign grade to a student");
            System.out.println("4. Calculate overall course grade for a student");
            System.out.println("5. Exit");

            int choice = scanner.nextInt(); // wait for user's input
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewCourse();
                    break;
                case 2:
                    enrollStudentInCourse();
                    break;
                case 3:
                    assignGradeToStudent();
                    break;
                case 4:
                    calculateOverallGradeForStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewCourse() {
        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        System.out.println("Enter course name:");
        String name = scanner.nextLine();
        System.out.println("Enter maximum capacity:");
        int maxCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        CourseManagement.addCourse(courseCode, name, maxCapacity);
        System.out.println("Course added successfully.");
    }

    private static void enrollStudentInCourse() {
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();

        Student student = new Student(studentName, studentId);

        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);

        if (course != null) {
            CourseManagement.enrollStudent(student, course);
            System.out.println("Student enrolled successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void assignGradeToStudent() {
        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();

        System.out.println("Enter course code:");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);

        System.out.println("Enter grade:");
        String grade = scanner.nextLine();

        Student student = findStudentById(studentId);
        if (student != null && course != null) {
            CourseManagement.assignGrade(student, course, grade);
            System.out.println("Grade assigned successfully.");
        } else {
            System.out.println("Student or course not found.");
        }
    }

    private static void calculateOverallGradeForStudent() {
        System.out.println("Enter student ID:");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);

        if (student != null) {
            CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall grade calculated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static Student findStudentById(String studentId) {
        // Implement logic to find student by ID (for simplicity, we return null)
        return null;
    }
}