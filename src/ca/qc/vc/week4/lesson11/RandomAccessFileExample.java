package ca.qc.vc.week4.lesson11;

import java.io.*;

public class RandomAccessFileExample {

    public static void main(String[] args) {

        try {
            RandomAccessFile raf =
                    new RandomAccessFile("test.txt", "rw");

            // Write to the file
            raf.writeUTF("Hello World");

            // Go back to the beginning
            raf.seek(0);

            // Read from the file
            String message = raf.readUTF();
            System.out.println("Read message: " + message);

            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}