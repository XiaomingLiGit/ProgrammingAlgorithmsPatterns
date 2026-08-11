package solutions.week6.lesson17;

public class Lab1SumOfArray {

    public static int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        return sum(array, 0, array.length - 1);
    }

    private static int sum(int[] array, int left, int right) {
        // Base case: only one element
        if (left == right) {
            return array[left];
        }

        // Divide
        int middle = left + (right - left) / 2;

        // Conquer
        int leftSum = sum(array, left, middle);
        int rightSum = sum(array, middle + 1, right);

        // Combine
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 8, 2, 10, 7};

        System.out.println("Sum = " + sum(numbers));
    }
}