package ca.qc.vc.week1.lesson1;

public class BreakContinueComparison {

    public static void main(String[] args) {

        System.out.println("=== Loop with continue ===");

        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                // Skip the rest of this iteration when i is even
                continue;
            }

            System.out.println("Value: " + i);
        }

        System.out.println("\n=== Loop with break ===");

        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 0) {
                // Exit the loop entirely when i is even
                break;
            }

            System.out.println("Value: " + i);
        }
    }
}