package ca.qc.vc.week6.lesson18;

import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] nums,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Make choice
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        List<List<Integer>> ans = subsets(nums);

        System.out.println(ans);
    }
}