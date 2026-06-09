import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentManager manager = new StudentManager();
        FileManager fileManager = new FileManager();
        TextFileHandler textFile = new TextFileHandler();
        BinaryFileHandler binaryFile = new BinaryFileHandler();
        SerializationHandler serFile = new SerializationHandler();

        fileManager.initializeFiles();

        while (true) {

            System.out.println("\n===== STUDENT SYSTEM MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Save to Text File");
            System.out.println("7. Load from Text File");
            System.out.println("8. Save to Binary File");
            System.out.println("9. Load from Binary File");
            System.out.println("10. Save Serialization");
            System.out.println("11. Load Serialization");
            System.out.println("12. Create Backup");
            System.out.println("0. Exit");

            int choice = input.nextInt();

            if (choice == 0) break;

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Name: ");
                    String name = input.nextLine();

                    System.out.print("Department: ");
                    String dept = input.nextLine();

                    System.out.print("GPA: ");
                    double gpa = input.nextDouble();

                    manager.addStudent(new Student(id, name, dept, gpa));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    Student s = manager.searchStudent(input.nextInt());
                    System.out.println(s != null ? s : "Not found");
                    break;

                case 3:
                    System.out.print("ID: ");
                    int uid = input.nextInt();
                    input.nextLine();

                    System.out.print("New Name: ");
                    String n = input.nextLine();

                    System.out.print("New Department: ");
                    String d = input.nextLine();

                    System.out.print("New GPA: ");
                    double g = input.nextDouble();

                    System.out.println(manager.updateStudent(uid, n, d, g)
                            ? "Updated"
                            : "Not found");
                    break;

                case 4:
                    System.out.print("ID: ");
                    System.out.println(manager.deleteStudent(input.nextInt())
                            ? "Deleted"
                            : "Not found");
                    break;

                case 5:
                    manager.displayStudents();
                    break;

                case 6:
                    textFile.saveToFile(manager.getStudents());
                    break;

                case 7:
                    manager.getStudents().clear();
                    manager.getStudents().addAll(textFile.loadFromFile());
                    break;

                case 8:
                    binaryFile.saveToBinary(manager.getStudents());
                    break;

                case 9:
                    manager.getStudents().clear();
                    manager.getStudents().addAll(binaryFile.loadFromBinary());
                    break;

                case 10:
                    serFile.saveObjects(manager.getStudents());
                    break;

                case 11:
                    manager.getStudents().clear();
                    manager.getStudents().addAll(serFile.loadObjects());
                    break;

                case 12:
                    fileManager.createBackup();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}