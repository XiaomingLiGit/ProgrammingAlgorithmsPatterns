package ca.qc.vc.week6.lesson17;

public class GACoinChange {
    public static int coinChange(int[] coins, int amount) {
        int count = 0;

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        int amount = 41;

        // GA fails in the following case
//        int[] coins = [4, 3, 1];
//        int amount = 6;

        System.out.println(coinChange(coins, amount));
    }
}
