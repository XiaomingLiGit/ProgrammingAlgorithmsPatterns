package ca.qc.vc.week4.lesson11;

import java.io.FileNotFoundException;

public class ThrowExample {

    // Directly throws an exception
    static void openFile(String fileName)
            throws FileNotFoundException {

        if (!fileName.equals("data.txt")) {
            throw new FileNotFoundException(
                    "Cannot find file: " + fileName
            );
        }

        System.out.println("File opened successfully.");
    }

    // Propagator: passes the exception to its caller
    static void prepareReport(String fileName)
            throws FileNotFoundException {

        openFile(fileName);
    }

    // Catcher: catches and handles the exception
    public static void main(String[] args) {

        try {
            prepareReport("students.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}