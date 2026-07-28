package ca.qc.vc.week4.lesson11;

import java.io.*;

public class BufferedInputDemo {

    public static void main(String[] args) throws IOException {
        try (BufferedInputStream bis =
                     new BufferedInputStream(
                             new FileInputStream("input.txt"))) {

            int b;

            while ((b = bis.read()) != -1) {
                System.out.print((char) b);
            }
        }
    }
}