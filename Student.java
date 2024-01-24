import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String address;
    private int numCourses;
    private List<Integer> grades;

    public Student(String name, String address, int numCourses) {
        this.name = name;
        this.address = address;
        this.numCourses = numCourses;
        this.grades = new ArrayList<Integer>();
    }

    public void addCourseGrade(String course, int grade) {
        System.out.println("Added course: " + course + ", grade: " + grade);
        this.grades.add(grade);
    }

    public void printGrades() {
        System.out.println("Student's grades: ");
        for (int i = 0; i < this.grades.size(); i++) {
            System.out.println("Course " + (i + 1) + ": " + this.grades.get(i));
        }
    }

    public static void main(String[] args) {
        Student obj = new Student("Sovisal", "Phnom penh", 5);
        try {
            obj.addCourseGrade("Java", 100);
            obj.addCourseGrade("Network", 98);
            obj.addCourseGrade("STA", 100);
            obj.addCourseGrade("C#", 100);
            obj.addCourseGrade("MIS", 80);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        obj.printGrades();
    }
}