package ca.qc.vc.week4.lesson11;

import java.io.*;

public class BufferedCopy {

    public static void main(String[] args) {
        try (
                BufferedInputStream in =
                        new BufferedInputStream(
                                new FileInputStream("source.jpg"));
                BufferedOutputStream out =
                        new BufferedOutputStream(
                                new FileOutputStream("copy.jpg"))
        ) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            out.flush();  // Ensure all data is written
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}