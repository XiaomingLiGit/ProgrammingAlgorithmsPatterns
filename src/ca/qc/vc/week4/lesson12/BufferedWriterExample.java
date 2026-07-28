package ca.qc.vc.week4.lesson12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter("output.txt"))) {

            writer.write("Hello from BufferedWriter!");

            // Platform-independent newline
            writer.newLine();

            writer.write("Writing text efficiently.");

            // Ensure everything is written
            writer.flush();
        }
    }
}