package ca.qc.vc.week6.lesson16;

import java.util.Arrays;

public class MatrixOperations {

    // Matrix addition: C = A + B
    public static int[][] add(int[][] A, int[][] B) {
        validateDimensions(A, B);

        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    // Matrix subtraction: C = A - B
    public static int[][] subtract(int[][] A, int[][] B) {
        validateDimensions(A, B);

        int rows = A.length;
        int cols = A[0].length;
        int[][] C = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        if (colsA != B.length) {
            throw new IllegalArgumentException(
                    "The number of columns in A must equal the number of rows in B.");
        }

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }


    private static void validateDimensions(int[][] A, int[][] B) {
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new IllegalArgumentException(
                    "Matrices must have the same dimensions.");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {6, 5, 4},
                {3, 2, 1}
        };

        System.out.println("A + B:");
        printMatrix(add(A, B));

        System.out.println("\nA - B:");
        printMatrix(subtract(A, B));
    }
}