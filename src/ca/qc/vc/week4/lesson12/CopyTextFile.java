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
                                new FileReader("output.txt"));

                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter("target_even.txt"));

                BufferedWriter writer_odd =
                        new BufferedWriter(
                        new FileWriter("target_odd.txt"))
        )
        {
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {

                if(counter % 2 == 0)
                {
                    writer.write(line);
                    writer.newLine();
                }
                else
                {
                    writer_odd.write(line);
                    writer_odd.newLine();
                }

                counter++;
            }
        }
    }
}