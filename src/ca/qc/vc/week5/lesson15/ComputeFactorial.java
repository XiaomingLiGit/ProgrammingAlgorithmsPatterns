package ca.qc.vc.week5.lesson15;

import java.util.Scanner;

public class ComputeFactorial {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = input.nextInt();

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));
        System.out.println("Factorial of " + n + " is " + factorial2(n));
    }

    /** Return the factorial for a specified number */
    public static long factorial(int n) {
        if (n == 0 || n == 1) // Base case
            return 1;
        else
            return n * factorial(n - 1); // Recursive call
    }

    public static long factorial2(int n) {
        if (n == 0 || n == 1)
            return 1;
        else
        {
            long result = 1;
            for (int i = 1; i <= n; i++)
                result = result * i;
            return result;
        }
    }



}