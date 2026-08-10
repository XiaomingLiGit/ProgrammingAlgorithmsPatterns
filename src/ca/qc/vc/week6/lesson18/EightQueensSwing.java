package ca.qc.vc.week6.lesson18;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EightQueensSwing extends JFrame {

    public static final int SIZE = 8;
    public static final int CELL_SIZE = 55;

    // queens[row] stores the column containing the queen
    // -1 means no queen has been placed in that row
    private final int[] queens =
            {-1, -1, -1, -1, -1, -1, -1, -1};

    public EightQueensSwing() {
        setTitle("Eight Queens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (search()) {
            add(createChessBoard());
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "No solution was found.",
                    "Eight Queens",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * Create and return the chess board.
     */
    private JPanel createChessBoard() {
        JPanel chessBoard = new JPanel(
                new GridLayout(SIZE, SIZE)
        );

        JLabel[][] labels = new JLabel[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                JLabel label = new JLabel("", SwingConstants.CENTER);

                label.setPreferredSize(
                        new Dimension(CELL_SIZE, CELL_SIZE)
                );

                label.setBorder(new LineBorder(Color.BLACK));
                label.setOpaque(true);

                // Use alternating chessboard colors
                if ((row + column) % 2 == 0) {
                    label.setBackground(Color.WHITE);
                } else {
                    label.setBackground(new Color(180, 180, 180));
                }

                labels[row][column] = label;
                chessBoard.add(label);
            }
        }

        // Display the queens
        for (int row = 0; row < SIZE; row++) {
            int column = queens[row];

            labels[row][column].setText("\u265B"); // ♛
            labels[row][column].setFont(
                    new Font("Serif", Font.PLAIN, 40)
            );
            labels[row][column].setForeground(Color.RED);
        }

        return chessBoard;
    }

    /**
     * Search for one solution using iterative backtracking.
     */
    private boolean search() {
        // k is the current row
        int k = 0;

        while (k >= 0 && k < SIZE) {
            // Find a valid column in row k
            int column = findPosition(k);

            if (column < 0) {
                // No valid position in this row
                queens[k] = -1;
                k--; // Backtrack to the previous row
            } else {
                // Place a queen and move to the next row
                queens[k] = column;
                k++;
            }
        }

        return k == SIZE;
    }

    /**
     * Find the next valid column in row k.
     */
    public int findPosition(int k) {
        int start = queens[k] + 1;

        for (int column = start; column < SIZE; column++) {
            if (isValid(k, column)) {
                return column;
            }
        }

        return -1;
    }

    /**
     * Return true if a queen can be placed at
     * the specified row and column.
     */
    public boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++) {
            int previousQueenColumn = queens[row - i];

            // Check the same column
            if (previousQueenColumn == column) {
                return false;
            }

            // Check the upper-left diagonal
            if (previousQueenColumn == column - i) {
                return false;
            }

            // Check the upper-right diagonal
            if (previousQueenColumn == column + i) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EightQueensSwing frame = new EightQueensSwing();
            frame.setVisible(true);
        });
    }
}