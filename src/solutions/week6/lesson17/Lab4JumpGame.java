package solutions.week6.lesson17;

public class Lab4JumpGame {

    public static boolean canReachLastIndex(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        int farthestReachableIndex = 0;

        for (int currentIndex = 0;
             currentIndex < numbers.length;
             currentIndex++) {

            // The current position cannot be reached
            if (currentIndex > farthestReachableIndex) {
                return false;
            }

            farthestReachableIndex = Math.max(
                    farthestReachableIndex,
                    currentIndex + numbers[currentIndex]
            );

            if (farthestReachableIndex
                    >= numbers.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] example1 = {2, 3, 1, 1, 4};
        int[] example2 = {3, 2, 1, 0, 4};

        System.out.println(
                "Example 1: "
                        + canReachLastIndex(example1)
        );

        System.out.println(
                "Example 2: "
                        + canReachLastIndex(example2)
        );
    }
}