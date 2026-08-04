package ca.qc.vc.week6.lesson17;

public class Knapsack {

    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;

        // dp[i][w] = maximum value using first i items with capacity w
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                // Cannot take item i
                dp[i][w] = dp[i - 1][w];

                // Can take item i
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            dp[i][w],
                            dp[i - 1][w - weights[i - 1]] + values[i - 1]
                    );
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;

        int result = knapsack(weights, values, W);
        System.out.println("Maximum value = " + result);
    }
}