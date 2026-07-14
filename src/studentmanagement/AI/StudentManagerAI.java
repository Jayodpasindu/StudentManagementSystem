package studentmanagement.AI;

import java.io.*;
import java.util.ArrayList;


public class StudentManagerAI {


    private ArrayList<StudentAI> students = new ArrayList<>();

    private final String FILE_NAME = "students.txt";


    // Add Student
    public void addStudent(StudentAI student) {

        students.add(student);
        saveToFile();

        System.out.println("Student added successfully.");
    }



    // View Students
    public void viewStudents() {

        if(students.isEmpty()){

            System.out.println("No students available.");
            return;
        }


        for(StudentAI student : students){

            System.out.println("--------------------");
            System.out.println("ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Course: " + student.getCourse());

        }

    }



    // Search Student

    public StudentAI searchStudent(String id){

        for(StudentAI student : students){

            if(student.getStudentId().equalsIgnoreCase(id)){
                return student;
            }

        }

        return null;
    }



    // Update Student

    public boolean updateStudent(String id,String name,int age,String course){


        StudentAI student = searchStudent(id);


        if(student != null){

            student.setName(name);
            student.setAge(age);
            student.setCourse(course);

            saveToFile();

            return true;
        }


        return false;
    }




    // Delete Student

    public boolean deleteStudent(String id){


        StudentAI student = searchStudent(id);


        if(student != null){

            students.remove(student);

            saveToFile();

            return true;
        }


        return false;

    }




    // Save Data

    public void saveToFile(){


        try{

            FileWriter writer = new FileWriter(FILE_NAME);


            for(StudentAI student : students){

                writer.write(student.toString());
                writer.write("\n");

            }


            writer.close();


        }
        catch(IOException e){

            System.out.println("File saving error.");

        }

    }





    // Load Data

    public void loadFromFile(){


        try{


            File file = new File(FILE_NAME);


            if(!file.exists()){
                return;
            }


            BufferedReader reader =
                    new BufferedReader(new FileReader(file));


            String line;


            while((line = reader.readLine()) != null){


                String data[] = line.split(",");


                StudentAI student =
                        new StudentAI(
                                data[0],
                                data[1],
                                Integer.parseInt(data[2]),
                                data[3]
                        );


                students.add(student);

            }


            reader.close();


        }
        catch(Exception e){

            System.out.println("Loading error.");

        }

    }


}