package ca.qc.vc.week4.lesson12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadText {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("text.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println("Read: " + line);
            }
        }
    }
}