package ca.qc.vc.week6.lesson18;

import java.util.Arrays;

public class CoinChangeDP {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i],
                            dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        int n = 5;
    }
}
