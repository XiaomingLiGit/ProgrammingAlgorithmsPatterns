package solutions.week4.lesson12;

import java.io.*;
import java.util.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double score;
    private transient String password;

    public Student(int id, String name, double score, String password) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.password = password;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", password='" + password + '\'' +
                '}';
    }
}

public class Lab7SerializeStudents {
    public static void main(String[] args) {
        String fileName = "students.dat";

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 88.5, "alice123"));
        students.add(new Student(2, "Bob", 92.0, "bob123"));
        students.add(new Student(3, "Charlie", 76.5, "charlie123"));
        students.add(new Student(4, "Diana", 95.0, "diana123"));
        students.add(new Student(5, "Eric", 81.0, "eric123"));

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(students);
            System.out.println("Student list saved.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            @SuppressWarnings("unchecked")
            ArrayList<Student> restoredStudents =
                    (ArrayList<Student>) in.readObject();

            restoredStudents.sort(
                    Comparator.comparingDouble(Student::getScore).reversed()
            );

            System.out.println("\nRestored students sorted by score:");
            for (Student s : restoredStudents) {
                System.out.println(s);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}