package services;

import models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement implements Management<Student> {
    private List<Student> studentList = new ArrayList<>();

    public StudentManagement(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentManagement() {
        studentList = new ArrayList<>();
    }

    @Override
    public void print() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }

    }

    @Override
    public void add(Student student) {
        studentList.add(student);

    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(Student student, int id) {
        int index = findIndexById(id);
        studentList.set(index, student);

    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(id);
            }
        }
    }

    public Student creat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter math score: ");
        double mathScore = scanner.nextDouble();
        System.out.print("Enter chemistry score: ");
        double chemistryScore = scanner.nextDouble();
        System.out.print("Enter physical score: ");
        double physicalScore = scanner.nextDouble();
        return new Student(id, age, name, mathScore, chemistryScore, physicalScore);
    }

    public void sortByAvg() {
        studentList.sort((p1, p2) -> (int) (p1.avg() - p2.avg()));
    }

    public void findMaxAvg() {
        double max = studentList.get(0).avg();
        int index = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (max < studentList.get(i).avg()) ;
            max = studentList.get(i).avg();
            index = i;
        }
        System.out.println(studentList.get(index));
    }

}

