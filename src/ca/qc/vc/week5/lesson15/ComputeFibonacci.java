package ca.qc.vc.week5.lesson15;

import java.util.Scanner;

public class ComputeFibonacci {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();

//        long begin1 = System.currentTimeMillis();
//        // Find and display the Fibonacci number
//        System.out.println("The Fibonacci number at index "
//                + index + " is " + fib(index));
//        long end1 = System.currentTimeMillis();
//        System.out.println("time elapse " + (end1-begin1));

        long begin2 = System.currentTimeMillis();
        long[] memo = new long[1000];
        System.out.println("The Fibonacci number at index "
                + index + " is " + fib(index, memo));
        long end2 = System.currentTimeMillis();
        System.out.println("time elapse " + (end2-begin2));

        long begin3 = System.currentTimeMillis();
        System.out.println("The Fibonacci number at index "
                + index + " is " + fibTabulation(index));
        long end3 = System.currentTimeMillis();
        System.out.println("time elapse " + (end3-begin3));
    }

    /** The method for finding the Fibonacci number, using naive recursion */
    static long fib(int index) {
        if (index == 0) // Base case
            return 0;
        else if (index == 1) // Base case
            return 1;
        else  // Reduction and recursive calls
            return fib(index - 1) + fib(index - 2);
    }

    /** Top-Down dynamic programing: using Memoization*/
    static long fib(int index, long[] memo) {
        if (index <= 1) return index;

        if (memo[index] != 0) {
            return memo[index];
        }

        memo[index] = fib(index - 1, memo) + fib(index - 2, memo);
        return memo[index];
    }


    /** Bottom-up Dynamic Programming: no recursion*/
    static long fibTabulation(int index) {
        if (index <= 1) return index;

        long[] dp = new long[index + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= index; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[index];
    }

}