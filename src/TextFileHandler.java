import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileHandler {

    private String fileName = "data/students.txt";

    // SAVE STUDENTS TO TEXT FILE
    public void saveToFile(ArrayList<Student> students) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));

            for (Student s : students) {
                writer.println(
                        s.getId() + "," +
                        s.getName() + "," +
                        s.getDepartment() + "," +
                        s.getGpa()
                );
            }

            writer.close();

            System.out.println("Saved to text file successfully.");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // LOAD STUDENTS FROM TEXT FILE
    public ArrayList<Student> loadFromFile() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String dept = data[2];
                double gpa = Double.parseDouble(data[3]);

                students.add(new Student(id, name, dept, gpa));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return students;
    }
}