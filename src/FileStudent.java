import models.Student;

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
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            System.out.println(content);
        }
        return null;
    }
}

