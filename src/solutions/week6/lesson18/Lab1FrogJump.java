package solutions.week6.lesson18;

public class Lab1FrogJump {

    public static long countWays(int n) {
        if (n < 0) {
            return 0;
        }

        // dp[i] = number of ways to reach stair i
        long[] dp = new long[n + 1];

        // One way to remain at stair 0
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // Jump 1 step
            dp[i] += dp[i - 1];

            // Jump 2 steps
            if (i >= 2) {
                dp[i] += dp[i - 2];
            }

            // Jump 3 steps
            if (i >= 3) {
                dp[i] += dp[i - 3];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Target stair: " + n);
        System.out.println(
                "Number of ways: " + countWays(n)
        );
    }
}