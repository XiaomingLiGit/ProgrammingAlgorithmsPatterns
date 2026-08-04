package solutions.week5.lesson15;

import java.util.Arrays;

public class RecursionLabs {

    // Lab 1: GCD using Euclid's Algorithm
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        // Base case
        if (b == 0) {
            return a;
        }

        // Recursive case
        return gcd(b, a % b);
    }

    // Lab 2: Sum of Digits
    public static int sumOfDigits(int number) {
        number = Math.abs(number);

        // Base case
        if (number < 10) {
            return number;
        }

        // Recursive case
        return number % 10 + sumOfDigits(number / 10);
    }

    // Lab 3: Reverse a String
    public static String reverse(String text) {
        // Base case
        if (text.length() <= 1) {
            return text;
        }

        // Recursive case
        return reverse(text.substring(1)) + text.charAt(0);
    }

    // Lab 4: Find the Maximum Value
    public static int findMaximum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException(
                    "The array cannot be null or empty.");
        }

        return findMaximum(numbers, numbers.length - 1);
    }

    private static int findMaximum(int[] numbers, int index) {
        // Base case
        if (index == 0) {
            return numbers[0];
        }

        // Recursive case
        int maximumOfPreviousElements =
                findMaximum(numbers, index - 1);

        return Math.max(numbers[index], maximumOfPreviousElements);
    }

    // Lab 5: Palindrome Checker
    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        return isPalindrome(text, 0, text.length() - 1);
    }

    private static boolean isPalindrome(
            String text, int left, int right) {

        // Base case
        if (left >= right) {
            return true;
        }

        // Characters do not match
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        // Recursive case
        return isPalindrome(text, left + 1, right - 1);
    }

    public static void main(String[] args) {

        // Lab 1
        System.out.println("GCD of 48 and 18: "
                + gcd(48, 18));

        // Lab 2
        System.out.println("Sum of digits in 5724: "
                + sumOfDigits(5724));

        // Lab 3
        System.out.println("Reverse of recursion: "
                + reverse("recursion"));

        // Lab 4
        int[] numbers = {12, 5, 27, 8, 19};
        System.out.println("Array: "
                + Arrays.toString(numbers));
        System.out.println("Maximum value: "
                + findMaximum(numbers));

        // Lab 5
        System.out.println("Is level a palindrome? "
                + isPalindrome("level"));

        System.out.println("Is hello a palindrome? "
                + isPalindrome("hello"));
    }
}