import java.util.ArrayList;

public class ReportGenerator {

    public void generateReport(ArrayList<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }

        int total = students.size();
        double sum = 0;

        double highest = students.get(0).getGpa();
        double lowest = students.get(0).getGpa();

        for (Student s : students) {
            double gpa = s.getGpa();
            sum += gpa;

            if (gpa > highest) highest = gpa;
            if (gpa < lowest) lowest = gpa;
        }

        double avg = sum / total;

        System.out.println("\n===== REPORT =====");
        System.out.println("Total: " + total);
        System.out.println("Highest GPA: " + highest);
        System.out.println("Lowest GPA: " + lowest);
        System.out.println("Average GPA: " + avg);
    }
}