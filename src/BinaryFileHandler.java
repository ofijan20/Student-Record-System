import java.io.*;
import java.util.ArrayList;

public class BinaryFileHandler {

    private String fileName = "data/students.dat";

    // SAVE TO BINARY FILE
    public void saveToBinary(ArrayList<Student> students) {

        try {

            DataOutputStream dos =
                    new DataOutputStream(
                            new FileOutputStream(fileName));

            for (Student s : students) {

                dos.writeInt(s.getId());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getDepartment());
                dos.writeDouble(s.getGpa());
            }

            dos.close();

            System.out.println("Saved to binary file.");

        } catch (IOException e) {
            System.out.println("Error saving binary file: " + e.getMessage());
        }
    }

    // LOAD FROM BINARY FILE
    public ArrayList<Student> loadFromBinary() {

        ArrayList<Student> students = new ArrayList<>();

        try {

            DataInputStream dis =
                    new DataInputStream(
                            new FileInputStream(fileName));

            while (dis.available() > 0) {

                int id = dis.readInt();
                String name = dis.readUTF();
                String dept = dis.readUTF();
                double gpa = dis.readDouble();

                students.add(new Student(id, name, dept, gpa));
            }

            dis.close();

        } catch (IOException e) {
            System.out.println("Error reading binary file: " + e.getMessage());
        }

        return students;
    }
}