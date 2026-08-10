package ca.qc.vc.week4.lesson11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileExample {

    public static void main(String[] args) {
        try {
            Scanner fileScanner =
                    new Scanner(new File("test1.txt"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Line: " + line);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}