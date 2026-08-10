package ca.qc.vc.week4.lesson11;

import java.io.*;

public class DataStreamDemo {

    private static final String FILE_NAME = "student.dat";

    public static void main(String[] args) {
        writeData();
        readData();
    }

    private static void writeData() {
        try (DataOutputStream out =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(FILE_NAME)))) {

            out.writeInt(101);
            out.writeUTF("Alice");
            out.writeDouble(95.5);
            out.writeBoolean(true);

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData() {
        try (DataInputStream in =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(FILE_NAME)))) {

            int id = in.readInt();
            String name = in.readUTF();
            double score = in.readDouble();
            boolean passed = in.readBoolean();

            System.out.println("read student info from the file: ");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Score: " + score);
            System.out.println("Passed: " + passed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}