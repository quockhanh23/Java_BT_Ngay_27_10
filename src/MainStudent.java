import models.Student;
import services.StudentManagement;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.add(new Student(1, 12, "khánh", 5, 1, 9));
        studentManagement.add(new Student(2, 13, "khánh2", 4, 3, 1));
        studentManagement.add(new Student(3, 14, "khánh3", 1, 2, 1));
        studentManagement.add(new Student(4, 15, "khánh4", 1, 1, 1));

        int choice = -1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Main menu: ");
                System.out.println("1. Print list. ");
                System.out.println("2. Add. ");
                System.out.println("3. Edit. ");
                System.out.println("4. Delete. ");
                System.out.println("5. sort by Avg. ");
                System.out.println("0. End program. ");
                choice = scanner.nextInt();
            } catch (Exception ignored) {
                System.out.println("Wrong input!. ");
                System.out.println("Back to menu. ");
            }
            switch (choice) {
                case 1:
                    studentManagement.print();
                    break;
                case 2:
                    studentManagement.add(studentManagement.creat());
                    break;
                case 3:
                    int editById = scanner.nextInt();
                    studentManagement.update(studentManagement.creat(), editById);
                    break;
                case 4:
                    int deleteById = scanner.nextInt();
                    studentManagement.deleteById(deleteById);
                    break;
                case 5:
                    studentManagement.sortByAvg();
                    break;
                case 6:
                    studentManagement.findMaxAvg();
                    break;
                case 0:
                    System.exit(0);

            }
        }
    }
}
