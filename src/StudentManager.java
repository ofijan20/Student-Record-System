import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // ADD STUDENT
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // SEARCH STUDENT
    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // UPDATE STUDENT
    public boolean updateStudent(int id, String name, String dept, double gpa) {

        Student s = searchStudent(id);

        if (s != null) {
            s.setName(name);
            s.setDepartment(dept);
            s.setGpa(gpa);
            return true;
        }

        return false;
    }

    // DELETE STUDENT
    public boolean deleteStudent(int id) {

        Student s = searchStudent(id);

        if (s != null) {
            students.remove(s);
            return true;
        }

        return false;
    }

    // DISPLAY ALL STUDENTS
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // GET ALL STUDENTS (for files later)
    public ArrayList<Student> getStudents() {
        return students;
    }
}