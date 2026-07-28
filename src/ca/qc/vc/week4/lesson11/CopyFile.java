package ca.qc.vc.week4.lesson11;

import java.io.*;

public class CopyFile {

    public static void main(String[] args) {
        try (
                FileInputStream in =
                        new FileInputStream("source.txt");
                FileOutputStream out =
                        new FileOutputStream("copy.txt")
        ) {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            System.out.println("File copied.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}