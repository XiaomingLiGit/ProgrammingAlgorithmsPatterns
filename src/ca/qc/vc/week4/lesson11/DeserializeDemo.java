package ca.qc.vc.week4.lesson11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {

    public static void main(String[] args) {
        try (ObjectInputStream ois =
                     new ObjectInputStream(
                             new FileInputStream("student.dat"))) {

            Student s = (Student) ois.readObject();

            System.out.println("Deserialized: " + s);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}