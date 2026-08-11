package solutions.week6.lesson17;

import java.util.Arrays;

public class Lab3MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(
            int[] array, int left, int right) {

        // Base case
        if (left >= right) {
            return;
        }

        // Divide
        int middle = left + (right - left) / 2;

        // Conquer
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);

        // Combine
        merge(array, left, middle, right);
    }

    private static void merge(
            int[] array,
            int left,
            int middle,
            int right) {

        int[] temporary = new int[right - left + 1];

        int leftIndex = left;
        int rightIndex = middle + 1;
        int temporaryIndex = 0;

        // Merge the two sorted halves
        while (leftIndex <= middle
                && rightIndex <= right) {

            if (array[leftIndex] <= array[rightIndex]) {
                temporary[temporaryIndex] = array[leftIndex];
                leftIndex++;
            } else {
                temporary[temporaryIndex] = array[rightIndex];
                rightIndex++;
            }

            temporaryIndex++;
        }

        // Copy remaining elements from the left half
        while (leftIndex <= middle) {
            temporary[temporaryIndex] = array[leftIndex];
            leftIndex++;
            temporaryIndex++;
        }

        // Copy remaining elements from the right half
        while (rightIndex <= right) {
            temporary[temporaryIndex] = array[rightIndex];
            rightIndex++;
            temporaryIndex++;
        }

        // Copy the result back into the original array
        for (int i = 0; i < temporary.length; i++) {
            array[left + i] = temporary[i];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println(
                "Before sorting: " + Arrays.toString(numbers)
        );

        mergeSort(numbers);

        System.out.println(
                "After sorting:  " + Arrays.toString(numbers)
        );
    }
}