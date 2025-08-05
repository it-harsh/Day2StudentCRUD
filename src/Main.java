import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student>  students = new ArrayList<>();

        //Adding demo students
        students.add(new Student(1,"Virat",95));
        students.add(new Student(2,"Dhoni",90));
        students.add(new Student(3,"Rohit",97));

        int id = 4;

        while(true) {

            System.out.println("----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Find Student");
            System.out.println("5. Show All Students List");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name : ");
                    String name = scanner.next();
                    System.out.print("Enter Student Marks : ");
                    int marks = scanner.nextInt();
                    students.add(new Student(id, name, marks));
                    id++;
                    System.out.println("Student Added Successfully!");
                    break;
                case 2:
                    displayStudents(students);
                    System.out.print("Enter Student Id to Update Record : ");
                    int studentId = scanner.nextInt();
                    System.out.println("Do you want to update : 1. Name or 2. Marks");
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.print("Enter Student Name : ");
                            String name2 = scanner.next();
                            for (Student s : students) {
                                if (s.getId() == studentId) {
                                    s.setName(name2);
                                    break;
                                }
                            }
                            System.out.println("Updated Student Name Successfully!");
                            break;
                        case 2:
                            System.out.print("Enter Student Marks : ");
                            int marks2 = scanner.nextInt();
                            for (Student s : students) {
                                if (s.getId() == studentId) {
                                    s.setMarks(marks2);
                                    break;
                                }
                            }
                            System.out.println("Updated Student Marks Successfully!");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    displayStudents(students);
                    System.out.print("Enter Student Id to Delete Record : ");
                    int id2 = scanner.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == id2) {
                            found = true;
                            students.remove(s);
                            System.out.println("Deleted Student Successfully!");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid Student Id");
                    }
                    break;
                case 4:
                    System.out.print("Find Student by Id : ");
                    int id3 = scanner.nextInt();
                    boolean f = false;
                    for (Student s : students) {
                        if (s.getId() == id3) {
                            f = true;
                            System.out.println("Student Found Successfully!");
                            System.out.println("    Id : " + s.getId());
                            System.out.println("    Name : " + s.getName());
                            System.out.println("    Marks : " + s.getMarks());
                            break;
                        }
                    }
                    if (!f) {
                        System.out.println("Invalid Student Id");
                    }
                    break;
                case 5:
                    displayStudents(students);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void displayStudents(ArrayList<Student> students) {
        int i=1;
        for (Student student : students) {
            System.out.println(i++ +". -----");
            System.out.println("    Id : "+student.getId());
            System.out.println("    Name : "+student.getName());
            System.out.println("    Marks : "+student.getMarks());
        }
    }

}
