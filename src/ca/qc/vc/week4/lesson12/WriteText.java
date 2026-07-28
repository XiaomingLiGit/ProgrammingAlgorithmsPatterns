package ca.qc.vc.week4.lesson12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteText {

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter("text.txt"))) {

            writer.write("Hello, World!");
            writer.newLine();
            writer.write("BufferedWriter makes it efficient.");
        }
    }
}