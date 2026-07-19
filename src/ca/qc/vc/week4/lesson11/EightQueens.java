package ca.qc.vc.week4.lesson11;

public class EightQueens {
    public static final int SIZE = 8;

    // queens[i] means the queen in row i is placed at column queens[i]
    // -1 means no queen is placed in that row
    private int[] queens = {-1, -1, -1, -1, -1, -1, -1, -1};

    public static void main(String[] args) {
        EightQueens solver = new EightQueens();

        boolean found = solver.search();

        if (found) {
            System.out.println("A solution is found:");
            solver.printBoard();
        } else {
            System.out.println("No solution found.");
        }
    }

    /** Search for a solution using backtracking */
    private boolean search() {
        int k = 0; // current row

        while (k >= 0 && k < SIZE) {
            int j = findPosition(k);

            if (j < 0) {
                queens[k] = -1;
                k--; // backtrack to previous row
            } else {
                queens[k] = j;
                k++; // move to next row
            }
        }

        return k == SIZE;
    }

    /** Find a valid column position for row k */
    private int findPosition(int k) {
        int start = queens[k] + 1;

        for (int j = start; j < SIZE; j++) {
            if (isValid(k, j)) {
                return j;
            }
        }

        return -1;
    }

    /** Check whether a queen can be placed at (row, column) */
    private boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            if (queens[row - i] == column
                    || queens[row - i] == column - i
                    || queens[row - i] == column + i) {
                return false;
            }
        }

        return true;
    }

    /** Print the chessboard in console */
    private void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Queen positions:");
        for (int i = 0; i < SIZE; i++) {
            System.out.println("Row " + i + ", Column " + queens[i]);
        }
    }
}