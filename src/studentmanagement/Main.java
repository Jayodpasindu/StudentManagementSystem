package studentmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    Student student = new Student(id, name, age, course);
                    manager.addStudent(student);
                    break;


                case 2:
                    manager.viewStudents();
                    break;


                case 3:
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();

                    Student foundStudent = manager.searchStudent(searchId);

                    if (foundStudent != null) {
                        System.out.println("Student Found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;


                case 4:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();

                    boolean updated = manager.updateStudent(
                            updateId,
                            newName,
                            newAge,
                            newCourse
                    );

                    if (updated) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;


                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine();

                    boolean deleted = manager.deleteStudent(deleteId);

                    if (deleted) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;


                case 6:
                    System.out.println("Exiting program...");
                    break;


                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);


        scanner.close();
    }
}