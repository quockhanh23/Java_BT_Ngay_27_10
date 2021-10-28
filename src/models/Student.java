package models;

public class Student extends Person {
    private double mathScore;
    private double chemistryScore;
    private double physicalScore;

    public Student(int id, int age, String name, double mathScore, double chemistryScore, double physicalScore) {
        super(id, age, name);
        this.mathScore = mathScore;
        this.chemistryScore = chemistryScore;
        this.physicalScore = physicalScore;
    }

    public Student(int id, int age, String name) {
        super(id, age, name);
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(int chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public double getPhysicalScore() {
        return physicalScore;
    }

    public void setPhysicalScore(int physicalScore) {
        this.physicalScore = physicalScore;
    }

    public double avg() {
        double avg = ((mathScore + chemistryScore + physicalScore) / 3);
        return avg;
    }


    @Override
    public String toString() {

        return String.format("%-5s%-10s%-7s%-10s%-12s%-5s",
                getId(), getName(), getAge(),getMathScore(),getChemistryScore(),getPhysicalScore());
    }
}
