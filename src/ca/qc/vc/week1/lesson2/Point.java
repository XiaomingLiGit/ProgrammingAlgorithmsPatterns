package ca.qc.vc.week1.lesson2;

public class Point {

    private int x;
    private int y;

    // Constructor parameters shadow field names
    public Point(int x, int y) {
        // Without "this.", assignments would refer to the parameters themselves.
        this.x = x;  // set the field x to the parameter x
        this.y = y;  // set the field y to the parameter y
    }

    public void moveTo(int x, int y) {
        // Again: use "this." to update the object's fields
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p = new Point(3, 5);

        System.out.println("Initial: " + p);  // prints "(3, 5)"

        p.moveTo(10, 20);

        System.out.println("Moved to: " + p); // prints "(10, 20)"
    }
}