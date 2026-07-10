package ca.qc.vc.week2.lesson6;
import java.util.*;



class Student implements Comparable<Student> {
    private String name;
    private double gpa;


    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 3.8));
        students.add(new Student("Bob", 3.5));
        students.add(new Student("Charlie", 3.9));

        Collections.sort(students);

        System.out.println(students);
    }
}
