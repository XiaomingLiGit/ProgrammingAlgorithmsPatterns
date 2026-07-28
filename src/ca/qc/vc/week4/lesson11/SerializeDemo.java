package ca.qc.vc.week4.lesson11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {

    public static void main(String[] args) {
        Student s = new Student("Alice", 95);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream("student.dat"))) {

            oos.writeObject(s);
            System.out.println("Object serialized.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{name='" + name
                + "', score=" + score + "}";
    }
}