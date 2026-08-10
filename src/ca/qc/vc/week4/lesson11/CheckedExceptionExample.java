package ca.qc.vc.week4.lesson11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionExample {

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(new File("students.txt"));

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file path.");
            e.printStackTrace();
        }
    }
}