package ca.qc.vc.week4.lesson12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DecoratorIODemo {

    private static final String FILE_NAME = "student.dat";

    public static void main(String[] args) {
        try {
            writeStudentData();
            readStudentData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeStudentData() throws IOException {

        try (DataOutputStream out =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(FILE_NAME)))) {

            // Write student data
            out.writeInt(101);
            out.writeUTF("Alice");
            out.writeDouble(95.5);
            out.writeBoolean(true);

            System.out.println("Student data written.");
        }
    }

    private static void readStudentData() throws IOException {

        try (DataInputStream in =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(FILE_NAME)))) {

            // Reading order must match writing order
            int id = in.readInt();
            String name = in.readUTF();
            double score = in.readDouble();
            boolean fullTime = in.readBoolean();

            System.out.println("\nStudent data read from file:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);
            System.out.println("Full-time: " + fullTime);
        }
    }
}