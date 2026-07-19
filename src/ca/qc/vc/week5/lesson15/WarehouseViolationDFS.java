package ca.qc.vc.week5.lesson15;

import java.util.*;

// live coding interview question
public class WarehouseViolationDFS {

    static char[][] grid = {
            {'.', 'S', 'F', 'F', '.'},
            {'S', 'C', 'F', '.', '.'},
            {'.', 'C', 'S', '.', '.'},
            {'.', '.', '.', 'C', 'F'},
            {'.', '.', '.', 'F', 'F'}
    };

    static int numRow = grid.length;
    static int numColumn = grid[0].length;

    static boolean[][] visitedMatrix = new boolean[numRow][numColumn];

    public static void main(String[] args) {
        int violationCounter = 0;

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numColumn; j++) {

                List<Character> cluster = new ArrayList<>();

                dfs(i, j, cluster);

                int chemicalCounter = count(cluster, 'C');
                int flammableCounter = count(cluster, 'F');

                if (chemicalCounter >= 3 ||
                        flammableCounter >= 5 ||
                        (chemicalCounter >= 1 && flammableCounter >= 1)) {

                    violationCounter++;
                }
            }
        }

        System.out.println("The number of violation is " + violationCounter);
    }

    public static void dfs(int row, int column, List<Character> cluster) {
        if (row < 0 || row >= numRow ||
                column < 0 || column >= numColumn ||
                visitedMatrix[row][column] ||
                grid[row][column] == '.') {

            return;
        }

        visitedMatrix[row][column] = true;
        cluster.add(grid[row][column]);

        dfs(row, column + 1, cluster); // right
        dfs(row + 1, column, cluster); // down
        dfs(row, column - 1, cluster); // left
        dfs(row - 1, column, cluster); // up
    }

    public static int count(List<Character> cluster, char target) {
        int counter = 0;

        for (char ch : cluster) {
            if (ch == target) {
                counter++;
            }
        }

        return counter;
    }
}