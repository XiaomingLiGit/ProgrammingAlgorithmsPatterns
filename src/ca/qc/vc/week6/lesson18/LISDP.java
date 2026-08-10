package ca.qc.vc.week6.lesson18;

import java.util.Arrays;

public class LISDP {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,1}));
    }
}
