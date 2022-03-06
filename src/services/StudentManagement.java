package services;

import models.Student;

import java.util.*;

public class StudentManagement implements Management<Student> {
    private AbstractList<Student> studentList = new ArrayList<>();

    public StudentManagement(AbstractList<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentManagement() {
    }

    public AbstractList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(AbstractList<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void print() {
        System.out.println(String.format("%-5s%-10s%-7s%-10s%-12s%-10s%-5s",
                "ID", "Name", "Age", "Math", "Chemistry", "Physical", "Avg"));
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
        int deleteById = findIndexById(id);
        studentList.remove(deleteById);
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

    public void sortByName() {
        studentList.sort(Comparator.comparing(Student::getName));
    }

    public void findMaxAvg() {
        double max = studentList.get(0).avg();
        int index = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (max < studentList.get(i).avg()) {
                max = studentList.get(i).avg();
                index = i;
            }
        }
        System.out.println(studentList.get(index));
    }

}

