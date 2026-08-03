package ca.qc.vc.week6.lesson16;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensAllSolutionsSwing extends JFrame {

    public static final int SIZE = 8;
    public static final int CELL_SIZE = 55;

    // queens[row] stores the column of the queen in that row
    private final int[] queens = new int[SIZE];

    // Store all solutions
    private final List<int[]> solutions = new ArrayList<>();

    private final JLabel[][] cells = new JLabel[SIZE][SIZE];
    private final JLabel solutionLabel = new JLabel();

    private final JButton previousButton = new JButton("Previous");
    private final JButton nextButton = new JButton("Next");

    private int currentSolutionIndex = 0;

    public EightQueensAllSolutionsSwing() {
        setTitle("Eight Queens - All Solutions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Arrays.fill(queens, -1);

        // Generate all solutions
        searchAllSolutions(0);

        add(createChessBoard(), BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);

        if (!solutions.isEmpty()) {
            displaySolution(0);
        }

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Create the chessboard.
     */
    private JPanel createChessBoard() {
        JPanel chessBoard = new JPanel(
                new GridLayout(SIZE, SIZE)
        );

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                JLabel cell = new JLabel(
                        "",
                        SwingConstants.CENTER
                );

                cell.setPreferredSize(
                        new Dimension(CELL_SIZE, CELL_SIZE)
                );

                cell.setBorder(new LineBorder(Color.BLACK));
                cell.setOpaque(true);
                cell.setFont(new Font("Serif", Font.PLAIN, 40));

                // Set alternating chessboard colors
                if ((row + column) % 2 == 0) {
                    cell.setBackground(Color.WHITE);
                } else {
                    cell.setBackground(new Color(180, 180, 180));
                }

                cells[row][column] = cell;
                chessBoard.add(cell);
            }
        }

        return chessBoard;
    }

    /**
     * Create buttons for navigating between solutions.
     */
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 15, 10)
        );

        previousButton.addActionListener(e -> {
            if (currentSolutionIndex > 0) {
                displaySolution(currentSolutionIndex - 1);
            }
        });

        nextButton.addActionListener(e -> {
            if (currentSolutionIndex < solutions.size() - 1) {
                displaySolution(currentSolutionIndex + 1);
            }
        });

        controlPanel.add(previousButton);
        controlPanel.add(solutionLabel);
        controlPanel.add(nextButton);

        return controlPanel;
    }

    /**
     * Display one solution on the chessboard.
     */
    private void displaySolution(int index) {
        currentSolutionIndex = index;

        // Clear the chessboard
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                cells[row][column].setText("");
            }
        }

        int[] solution = solutions.get(index);

        // Display queens
        for (int row = 0; row < SIZE; row++) {
            int column = solution[row];

            cells[row][column].setText("\u265B"); // ♛
            cells[row][column].setForeground(Color.RED);
        }

        solutionLabel.setText(
                "Solution " + (index + 1) +
                        " of " + solutions.size()
        );

        previousButton.setEnabled(index > 0);
        nextButton.setEnabled(index < solutions.size() - 1);

        setTitle(
                "Eight Queens - Solution " +
                        (index + 1) + " of " + solutions.size()
        );
    }

    /**
     * Recursively search for all solutions.
     */
    private void searchAllSolutions(int row) {
        // Base case: queens have been placed in all rows
        if (row == SIZE) {
            // Store a copy of the current solution
            solutions.add(queens.clone());
            return;
        }

        // Try every column in the current row
        for (int column = 0; column < SIZE; column++) {
            if (isValid(row, column)) {
                // Choose
                queens[row] = column;

                // Explore
                searchAllSolutions(row + 1);

                // Undo the choice
                queens[row] = -1;
            }
        }
    }

    /**
     * Check whether a queen can be placed at
     * the specified row and column.
     */
    private boolean isValid(int row, int column) {
        for (int previousRow = 0;
             previousRow < row;
             previousRow++) {

            int previousColumn = queens[previousRow];

            // Check the same column
            if (previousColumn == column) {
                return false;
            }

            // Check the diagonal
            int rowDifference = row - previousRow;
            int columnDifference =
                    Math.abs(column - previousColumn);

            if (rowDifference == columnDifference) {
                return false;
            }
        }

        return true;
    }

    /**
     * Print all solutions to the console.
     */
    private void printAllSolutions() {
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println(
                    "Solution " + (i + 1) + ": " +
                            Arrays.toString(solutions.get(i))
            );
        }

        System.out.println(
                "Total number of solutions: " + solutions.size()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EightQueensAllSolutionsSwing frame =
                    new EightQueensAllSolutionsSwing();

            frame.setVisible(true);

            // Optional: print all 92 solutions to the console
            frame.printAllSolutions();
        });
    }
}