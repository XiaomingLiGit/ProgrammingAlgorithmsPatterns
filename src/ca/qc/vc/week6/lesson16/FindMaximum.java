package ca.qc.vc.week6.lesson16;

public class FindMaximum {

    public static int findMax(int[] nums, int left, int right) {
        // Base Case
        if (left == right) {
            return nums[left];
        }

        // Divide
        int mid = (left + right) / 2;

        // Conquer
        int leftMax = findMax(nums, left, mid);
        int rightMax = findMax(nums, mid + 1, right);

        // Combine
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {

        int[] nums = {4, 7, 2, 9, 5};

        int result = findMax(nums, 0, nums.length - 1);

        System.out.println("Maximum = " + result);
    }
}