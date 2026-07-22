package solutions.week3.lesson8;

import java.util.*;

class Student {
    private int id;
    private String name;
    private String program;

    public Student(int id, String name, String program) {
        this.id = id;
        this.name = name;
        this.program = program;
    }

    public int getId() {
        return id;
    }

    // Compare students by student ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id +
                ", name='" + name + '\'' +
                ", program='" + program + '\'' +
                '}';
    }
}

public class Lab2HashSetStudents {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student s1 = new Student(1001, "Alice", "Computer Science");
        Student s2 = new Student(1002, "Bob", "Data Science");
        Student s3 = new Student(1003, "Charlie", "Business");

        Student s4 = new Student(1001, "Alex", "Engineering");
        Student s5 = new Student(1002, "Ben", "Mathematics");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println("Students in HashSet:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nSet size: " + students.size());

        Student target = new Student(1001, "Someone", "Unknown");
        System.out.println("\nContains student ID 1001?");
        System.out.println(students.contains(target));

        Student removeTarget = new Student(1002, "Any Name", "Any Program");
        students.remove(removeTarget);

        System.out.println("\nAfter removing student ID 1002:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("Final size: " + students.size());
    }
}