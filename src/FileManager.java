import java.io.*;

public class FileManager {

    private File dataFolder = new File("data");
    private File backupFolder = new File("backup");

    private File textFile = new File("data/students.txt");
    private File binaryFile = new File("data/students.dat");
    private File serFile = new File("data/students.ser");

    public void initializeFiles() {

        try {

            if (!dataFolder.exists()) dataFolder.mkdir();
            if (!backupFolder.exists()) backupFolder.mkdir();

            textFile.createNewFile();
            binaryFile.createNewFile();
            serFile.createNewFile();

            System.out.println("Files created successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void createBackup() {

        try {

            BufferedInputStream bis =
                    new BufferedInputStream(new FileInputStream("data/students.dat"));

            BufferedOutputStream bos =
                    new BufferedOutputStream(new FileOutputStream("backup/backup_students.dat"));

            int data;

            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

            bis.close();
            bos.close();

            System.out.println("Backup created successfully.");

        } catch (IOException e) {
            System.out.println("Backup error: " + e.getMessage());
        }
    }
}