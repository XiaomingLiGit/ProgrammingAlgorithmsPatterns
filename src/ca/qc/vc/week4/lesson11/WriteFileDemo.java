package ca.qc.vc.week4.lesson11;

import java.io.*;

public class WriteFileDemo {

    public static void main(String[] args) {
        try (FileOutputStream fos =
                     new FileOutputStream("output.txt")) {

            String text = "Hello, FileOutputStream!";
            fos.write(text.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}