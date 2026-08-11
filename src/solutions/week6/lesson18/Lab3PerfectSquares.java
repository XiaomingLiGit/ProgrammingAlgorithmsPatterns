package solutions.week6.lesson18;

public class Lab3PerfectSquares {

    public static int minimumPerfectSquares(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "n cannot be negative."
            );
        }

        // dp[i] = minimum number of perfect squares
        // whose sum equals i
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            // Worst case: i = 1 + 1 + ... + 1
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                int square = j * j;

                dp[i] = Math.min(
                        dp[i],
                        dp[i - square] + 1
                );
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;

        System.out.println("n = " + n);
        System.out.println(
                "Minimum number of perfect squares: "
                        + minimumPerfectSquares(n)
        );
    }
}