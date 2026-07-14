package studentmanagement;

import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println("----------------------------");
            System.out.println(student);
        }
    }

    public Student searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(String studentId, String name, int age, String course) {

        Student student = searchStudent(studentId);

        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setCourse(course);
            return true;
        }

        return false;
    }

    public boolean deleteStudent(String studentId) {

        Student student = searchStudent(studentId);

        if (student != null) {
            students.remove(student);
            return true;
        }

        return false;
    }
}