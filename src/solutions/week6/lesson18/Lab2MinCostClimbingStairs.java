package solutions.week6.lesson18;

import java.util.Arrays;

public class Lab2MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int n = cost.length;

        // dp[i] = minimum cost to reach position i
        // Position n represents the top
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int fromPreviousStep =
                    dp[i - 1] + cost[i - 1];

            int fromTwoStepsBefore =
                    dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(
                    fromPreviousStep,
                    fromTwoStepsBefore
            );
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};

        System.out.println(
                "Costs: " + Arrays.toString(cost)
        );

        System.out.println(
                "Minimum cost: "
                        + minCostClimbingStairs(cost)
        );
    }
}