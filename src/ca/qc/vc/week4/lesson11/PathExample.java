package ca.qc.vc.week4.lesson11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathExample {

    public static void main(String[] args) {

        Path folder = Path.of("data");
        Path file = folder.resolve("students.txt");

        try {
            Files.createDirectories(folder);

            Files.writeString(
                    file,
                    "Alice\nBob\nCharlie"
            );

            String content = Files.readString(file);

            System.out.println(content);
            System.out.println(
                    "File size: " + Files.size(file)
            );

        } catch (IOException e) {
            System.out.println(
                    "File operation failed: " + e.getMessage()
            );
        }
    }
}