package ca.qc.vc.week6.lesson16;

public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            // find the target
            if (nums[mid] == target)
                return mid;
            // left part is ordered
            if (nums[left] <= nums[mid]) {
                // target is in the left part (ordered)
                if (target >= nums[left]
                        && target < nums[mid])
                    right = mid - 1;
                // target is in the right part (unordered)
                else
                    left = mid + 1;

            }
            // right part is ordered
            else {
                // target is in the right part (ordered)
                if (target > nums[mid]
                        && target <= nums[right])
                    left = mid + 1;
                    // target is in the left part (unordered)
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {


    }
}
