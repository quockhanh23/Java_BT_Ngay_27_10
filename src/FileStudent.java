import models.Student;
import services.StudentManagement;

import java.io.*;
import java.util.List;

public class FileStudent {
    public static void WriteToFile(String path, List<Student> studentList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "ID, Name, Age, Math score, Chemistry score, physical score";
        for (Student student : studentList) {
            str += "\n";
            str += student.getId() + ",";
            str += student.getName() + ",";
            str += student.getAge() + ",";
            str += student.getMathScore() + ",";
            str += student.getChemistryScore() + ",";
            str += student.getPhysicalScore();
        }

        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Student> readFromFile(String path) throws IOException {
        StudentManagement studentManagement1 = new StudentManagement();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            int id = Integer.parseInt(arr[0]);
            String name = arr[1];
            int age = Integer.parseInt(arr[2]);
            double mathScore = Double.parseDouble(arr[3]);
            double chemistryScore = Double.parseDouble(arr[4]);
            double physicalScore = Double.parseDouble(arr[5]);
            studentManagement1.add(new Student(id, age, name, mathScore, chemistryScore, physicalScore));
        }
        studentManagement1.print();
        bufferedReader.close();
        return null;
    }
}

