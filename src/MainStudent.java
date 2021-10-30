import models.Student;
import services.StudentManagement;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) throws IOException {
        StudentManagement studentManagement = new StudentManagement();
        studentManagement.add(new Student(1, 12, "khánh55", 5, 1, 9));
        studentManagement.add(new Student(2, 13, "khánh2", 4, 3, 1));
        studentManagement.add(new Student(3, 14, "khánh3", 1, 2, 1));
        studentManagement.add(new Student(4, 15, "khánh4", 10, 1, 1));
//        FileWriter fileWriter = new FileWriter("src/demo.csv");
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        String str = "ID, Name, Age, Math score, Chemistry score, physical score";
//        for (int i = 0; i < studentManagement.getStudentList().size(); i++) {
//            Student student = studentManagement.getStudentList().get(i);
//            str += "\n";
//            str += student.getId() + ",";
//            str += student.getName() + ",";
//            str += student.getAge() + ",";
//            str += student.getMathScore() + ",";
//            str += student.getChemistryScore() + ",";
//            str += student.getPhysicalScore();
//        }
//        bufferedWriter.write(str);
//        bufferedWriter.close();

//        StudentManagement studentManagement1 = new StudentManagement();
//        FileReader fileReader = new FileReader("src/demo.csv");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line = bufferedReader.readLine();
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] arr = line.split(",");
//            int id = Integer.parseInt(arr[0]);
//            String name = arr[1];
//            int age = Integer.parseInt(arr[2]);
//            double mathScore  = Double.parseDouble(arr[3]);
//            double chemistryScore = Double.parseDouble(arr[4]);
//            double physicalScore = Double.parseDouble(arr[5]);
//            studentManagement1.add(new Student(id, age , name , mathScore, chemistryScore, physicalScore));
//        }
//        bufferedReader.close();
//        studentManagement1.print();

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
                System.out.println("6. Max Avg. ");
                System.out.println("7. Write To file. ");
                System.out.println("8. Read from file. ");
                System.out.println("0. End program. ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Print the list: ");
                        studentManagement.print();
                    }
                    case 2 -> {
                        System.out.println("Input student: ");
                        studentManagement.add(studentManagement.creat());
                    }
                    case 3 -> {
                        System.out.println("Enter id: ");
                        int editById = scanner.nextInt();
                        studentManagement.update(studentManagement.creat(), editById);
                        System.out.println("Id: " + editById + " Fixed. ");
                    }
                    case 4 -> {
                        System.out.println("Enter id: ");
                        int deleteById = scanner.nextInt();
                        studentManagement.deleteById(deleteById);
                        System.out.println("Id: " + deleteById + " Has been delete. ");
                    }
                    case 5 -> {
                        System.out.println("Sort by Avg: ");
                        studentManagement.sortByAvg();
                    }
                    case 6 -> {
                        System.out.println("Max avg: ");
                        studentManagement.findMaxAvg();
                    }
                    case 7 -> {
                        System.out.println("Read file. ");
                        FileStudent.WriteToFile("demo2.csv", studentManagement.getStudentList());
                    }
                    case 8 -> {
                        System.out.println("Print file. ");
                        FileStudent.readFromFile("demo2.csv");
                    }
                    case 9 -> {
                        System.out.println("Sort by name. ");
                        studentManagement.sortByName();
                    }
                    case 0 -> System.exit(0);
                }
            } catch (Exception e) {
                System.err.println("Wrong input!. ");
                System.err.println("Back to menu. ");
            }
        }
    }
}
