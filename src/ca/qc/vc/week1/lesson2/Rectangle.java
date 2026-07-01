package ca.qc.vc.week1.lesson2;

public class Rectangle {

    private int width;
    private int height;
    private String color;

    // 1) Full constructor
    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // 2) Constructor with default color
    public Rectangle(int width, int height) {
        this(width, height, "black");
        // Invokes the 3-arg constructor above with color="black"
    }

    // 3) Constructor square with default color
    public Rectangle(int size) {
        this(size, size);
        // Invokes the 2-arg constructor above (which itself calls the 3-arg)
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 6, "red");
        Rectangle r2 = new Rectangle(3, 5);  // color defaults to "black"
        Rectangle r3 = new Rectangle(7);     // a 7×7 square, color "black"

        System.out.println(r1);  // "Rectangle [w=4, h=6, color=red]"
        System.out.println(r2);  // "Rectangle [w=3, h=5, color=black]"
        System.out.println(r3);  // "Rectangle [w=7, h=7, color=black]"
    }
}