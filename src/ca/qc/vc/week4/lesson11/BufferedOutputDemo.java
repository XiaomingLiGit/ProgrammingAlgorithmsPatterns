package ca.qc.vc.week4.lesson11;

import java.io.*;

public class BufferedOutputDemo {

    public static void main(String[] args) throws IOException {
        try (BufferedOutputStream bos =
                     new BufferedOutputStream(
                             new FileOutputStream("output.txt"))) {

            String text = "Buffered OutputStream Example";
            bos.write(text.getBytes());

            bos.flush();  // Important: force write
        }
    }
}