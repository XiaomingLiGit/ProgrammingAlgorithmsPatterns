package ca.qc.vc.week5.lesson15;

import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangleSwing extends JFrame {

    private final SierpinskiTrianglePanel trianglePanel =
            new SierpinskiTrianglePanel();

    private final JTextField orderField = new JTextField(4);

    public SierpinskiTriangleSwing() {
        setTitle("Sierpinski Triangle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the input panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        inputPanel.add(new JLabel("Enter an order:"));

        orderField.setHorizontalAlignment(JTextField.RIGHT);
        inputPanel.add(orderField);

        // Add components to the frame
        add(trianglePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Press Enter to update the recursion order
        orderField.addActionListener(e -> updateOrder());

        setSize(500, 500);
        setLocationRelativeTo(null);
    }

    private void updateOrder() {
        try {
            int order = Integer.parseInt(orderField.getText().trim());

            if (order < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "The order must be a non-negative integer.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            trianglePanel.setOrder(order);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid integer.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
     * Panel for displaying the Sierpinski triangle.
     */
    static class SierpinskiTrianglePanel extends JPanel {

        private int order = 0;

        public SierpinskiTrianglePanel() {
            setBackground(Color.WHITE);
        }

        /**
         * Set a new recursion order.
         */
        public void setOrder(int order) {
            this.order = order;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g.create();

            // Make the triangle edges smoother
            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Select three points based on the panel size
            Point p1 = new Point(getWidth() / 2, 10);
            Point p2 = new Point(10, getHeight() - 10);
            Point p3 = new Point(getWidth() - 10, getHeight() - 10);

            displayTriangles(g2, order, p1, p2, p3);

            g2.dispose();
        }

        /**
         * Recursively draw the Sierpinski triangles.
         */
        private void displayTriangles(
                Graphics2D g2,
                int order,
                Point p1,
                Point p2,
                Point p3) {

            // Base case
            if (order == 0) {
                int[] xPoints = {p1.x, p2.x, p3.x};
                int[] yPoints = {p1.y, p2.y, p3.y};

                Polygon triangle =
                        new Polygon(xPoints, yPoints, 3);

                g2.setColor(Color.WHITE);
                g2.fillPolygon(triangle);

                g2.setColor(Color.BLACK);
                g2.drawPolygon(triangle);
            } else {
                // Find the midpoint of each edge
                Point p12 = midpoint(p1, p2);
                Point p23 = midpoint(p2, p3);
                Point p31 = midpoint(p3, p1);

                // Recursively draw three smaller triangles
                displayTriangles(g2, order - 1, p1, p12, p31);
                displayTriangles(g2, order - 1, p12, p2, p23);
                displayTriangles(g2, order - 1, p31, p23, p3);
            }
        }

        /**
         * Calculate the midpoint of two points.
         */
        private Point midpoint(Point p1, Point p2) {
            return new Point(
                    (p1.x + p2.x) / 2,
                    (p1.y + p2.y) / 2
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SierpinskiTriangleSwing frame =
                    new SierpinskiTriangleSwing();

            frame.setVisible(true);
        });
    }
}