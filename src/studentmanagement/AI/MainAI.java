package studentmanagement.AI;


import java.util.Scanner;


public class MainAI {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        StudentManagerAI manager = new StudentManagerAI();


        manager.loadFromFile();



        int choice;



        do{


            System.out.println("\n===== AI Student Management System =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");


            System.out.print("Enter choice: ");



            try{


                choice = scanner.nextInt();

                scanner.nextLine();



                switch(choice){



                    case 1:


                        System.out.print("Student ID: ");
                        String id = scanner.nextLine();



                        System.out.print("Name: ");
                        String name = scanner.nextLine();



                        int age;


                        while(true){

                            System.out.print("Age: ");

                            age = scanner.nextInt();


                            if(age > 0){

                                break;

                            }

                            else{

                                System.out.println(
                                        "Age must be positive.");

                            }

                        }


                        scanner.nextLine();



                        System.out.print("Course: ");

                        String course = scanner.nextLine();



                        manager.addStudent(
                                new StudentAI(id,name,age,course)
                        );


                        break;




                    case 2:

                        manager.viewStudents();

                        break;




                    case 3:


                        System.out.print("Enter ID: ");

                        String search =
                                scanner.nextLine();


                        StudentAI student =
                                manager.searchStudent(search);



                        if(student != null){

                            System.out.println(student);

                        }

                        else{

                            System.out.println(
                                    "Student not found.");

                        }


                        break;





                    case 4:


                        System.out.print("ID: ");

                        String updateId =
                                scanner.nextLine();


                        System.out.print("New Name: ");

                        String newName =
                                scanner.nextLine();



                        System.out.print("New Age: ");

                        int newAge =
                                scanner.nextInt();


                        scanner.nextLine();



                        System.out.print("New Course: ");

                        String newCourse =
                                scanner.nextLine();



                        if(manager.updateStudent(
                                updateId,
                                newName,
                                newAge,
                                newCourse)){


                            System.out.println(
                                    "Updated successfully.");

                        }

                        else{

                            System.out.println(
                                    "Student not found.");

                        }


                        break;





                    case 5:


                        System.out.print("Enter ID: ");

                        String deleteId =
                                scanner.nextLine();



                        if(manager.deleteStudent(deleteId)){

                            System.out.println(
                                    "Deleted successfully.");

                        }

                        else{

                            System.out.println(
                                    "Student not found.");

                        }


                        break;





                    case 6:

                        System.out.println(
                                "Exiting system...");

                        break;



                    default:

                        System.out.println(
                                "Invalid option.");

                }


            }

            catch(Exception e){


                System.out.println(
                        "Please enter a valid number.");


                scanner.nextLine();


                choice = 0;

            }



        }while(choice != 6);



        scanner.close();


    }

}