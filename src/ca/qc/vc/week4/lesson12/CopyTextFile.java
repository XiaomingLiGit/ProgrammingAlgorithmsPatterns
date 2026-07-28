package ca.qc.vc.week4.lesson12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextFile {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader("source.txt"));

                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter("target.txt"))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}