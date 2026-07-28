package ca.qc.vc.week4.lesson11;

import java.io.*;

public class ReadFileDemo {

    public static void main(String[] args) {
        try (FileInputStream fis =
                     new FileInputStream("input.txt")) {

            int data;

            while ((data = fis.read()) != -1) {
                // Assumes ASCII content
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}