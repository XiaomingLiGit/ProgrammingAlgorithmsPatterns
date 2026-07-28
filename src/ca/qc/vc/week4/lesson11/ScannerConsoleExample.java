package ca.qc.vc.week4.lesson11;

import java.util.Scanner;

public class ScannerConsoleExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  // Reads full line

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();  // Reads integer

        System.out.printf(
                "Hello %s, you are %d years old.%n",
                name,
                age
        );

        scanner.close();
    }
}