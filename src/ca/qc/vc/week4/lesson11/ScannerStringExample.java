package ca.qc.vc.week4.lesson11;

import java.util.Scanner;

public class ScannerStringExample {

    public static void main(String[] args) {
        String data = "101 Alice 95.5";
        Scanner scanner = new Scanner(data);

        int id = scanner.nextInt();
        String name = scanner.next();
        double score = scanner.nextDouble();

        System.out.printf(
                "ID: %d, Name: %s, Score: %.1f%n",
                id,
                name,
                score
        );

        scanner.close();
    }
}