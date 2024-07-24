public class Course {
    private String courseCode;
    private String name;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;
    private int currentEnrolledStudents = 0;

    public Course(String courseCode, String name, int maxCapacity) {
        this.courseCode = courseCode;
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentEnrolledStudents() {
        return currentEnrolledStudents;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public void incrementEnrolledStudents() {
        if (currentEnrolledStudents < maxCapacity) {
            currentEnrolledStudents++;
            totalEnrolledStudents++;
        } else {
            System.out.println("Course has reached its maximum capacity.");
        }
    }
}