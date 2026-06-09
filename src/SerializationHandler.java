import java.io.*;
import java.util.ArrayList;

public class SerializationHandler {

    private String fileName = "data/students.ser";

    // SAVE OBJECTS
    public void saveObjects(ArrayList<Student> students) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream(fileName))) {

            oos.writeObject(students);

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    // LOAD OBJECTS
    public ArrayList<Student> loadObjects() {

        ArrayList<Student> students = new ArrayList<>();

        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream(fileName))) {

            Object obj = ois.readObject();

            if (obj instanceof ArrayList<?>) {
                students = (ArrayList<Student>) obj;
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Load error: " + e.getMessage());
        }

        return students;
    }
}