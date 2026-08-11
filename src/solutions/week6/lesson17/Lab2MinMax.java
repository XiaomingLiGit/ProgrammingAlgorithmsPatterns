package solutions.week6.lesson17;

public class Lab2MinMax {

    static class MinMax {
        int minimum;
        int maximum;

        MinMax(int minimum, int maximum) {
            this.minimum = minimum;
            this.maximum = maximum;
        }
    }

    public static MinMax findMinMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(
                    "The array cannot be empty."
            );
        }

        return findMinMax(array, 0, array.length - 1);
    }

    private static MinMax findMinMax(
            int[] array, int left, int right) {

        // Base case: one element
        if (left == right) {
            return new MinMax(array[left], array[left]);
        }

        // Base case: two elements
        if (right == left + 1) {
            if (array[left] < array[right]) {
                return new MinMax(array[left], array[right]);
            } else {
                return new MinMax(array[right], array[left]);
            }
        }

        // Divide
        int middle = left + (right - left) / 2;

        // Conquer
        MinMax leftResult =
                findMinMax(array, left, middle);

        MinMax rightResult =
                findMinMax(array, middle + 1, right);

        // Combine
        int minimum = Math.min(
                leftResult.minimum,
                rightResult.minimum
        );

        int maximum = Math.max(
                leftResult.maximum,
                rightResult.maximum
        );

        return new MinMax(minimum, maximum);
    }

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        MinMax result = findMinMax(numbers);

        System.out.println("Minimum = " + result.minimum);
        System.out.println("Maximum = " + result.maximum);
    }
}