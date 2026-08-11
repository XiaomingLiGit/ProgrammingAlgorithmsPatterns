package solutions.week6.lesson18;

public class Lab1GenerateBinaryStrings {

    public static void generateBinaryStrings(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "Length cannot be negative."
            );
        }

        backtrack(n, new StringBuilder());
    }

    private static void backtrack(
            int n, StringBuilder current) {

        // Base case: a complete binary string
        if (current.length() == n) {
            System.out.println(current);
            return;
        }

        // Choose 0
        current.append('0');

        // Explore
        backtrack(n, current);

        // Undo the choice
        current.deleteCharAt(current.length() - 1);

        // Choose 1
        current.append('1');

        // Explore
        backtrack(n, current);

        // Undo the choice
        current.deleteCharAt(current.length() - 1);
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(
                "Binary strings of length " + n + ":"
        );

        generateBinaryStrings(n);
    }
}
