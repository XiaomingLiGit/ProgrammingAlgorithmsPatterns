package ca.qc.vc.week6.lesson16;

public class BinarySearchDC {

    // binary search, O(log n)
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    // linear search, O(n)
    static int searchWithoutDC(int[] nums, int target) {
        int index = 0;
        for(int e : nums) {
            if (target == e)
                return index;
            index++;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.println(searchWithoutDC(nums, target));

        System.out.println(search(nums, target));
    }
}
