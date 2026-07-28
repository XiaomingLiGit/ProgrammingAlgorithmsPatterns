package ca.qc.vc.week4.lesson11;

import java.io.File;
import java.io.PrintWriter;

public class WriteDataWithoutAutoClose {

    public static void main(String[] args) throws Exception {
        File file = new File("scores.txt");

        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        PrintWriter output = null;

        try {
            // Create a file
            output = new PrintWriter(file);

            // Write formatted output to the file
            output.print("John T. Perez ");
            output.println(90);

            output.print("Jamal K. Johnson ");
            output.println(85);

        } finally {
            if (output != null) {
                output.close();
            }
        }
    }
}