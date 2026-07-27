package solutions.midterm;

import java.util.*;

class Student implements Comparable<Student> {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.gpa, this.gpa); // descending GPA
    }

    @Override
    public String toString() {
        return id + " " + name + " " + gpa;
    }
}

public class StudentSortDemo {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S03", "Mary", 3.7));
        students.add(new Student("S01", "Alex", 3.9));
        students.add(new Student("S04", "Bob", 3.4));
        students.add(new Student("S02", "Diana", 3.8));

        Collections.sort(students);
        System.out.println(students);

        students.sort(Comparator.comparing(Student::getName));
        System.out.println(students);
    }
}
