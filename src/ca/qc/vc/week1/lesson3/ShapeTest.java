package ca.qc.vc.week1.lesson3;


import java.util.Random;

class Shape {
    void draw() {}
    void earse() {}
}
class Circle extends Shape {
    void draw() {  System.out.println("draw a circle");   }
    void earse() {  System.out.println("earse the circle");  }
}
class Square extends Shape {
    void draw() {   System.out.println("draw a square");   }
    void earse() {  System.out.println("earse the square");   }
}
class Triangle extends Shape {
    void draw() {  System.out.println("draw a triangle");  }
    void earse() {  System.out.println("earse the triangle");  }
}
public class ShapeTest {
    Shape[] shapes = new Shape[10];
    public ShapeTest() {
        Random random = new Random(47);
        for (int i = 0; i < shapes.length; ++i) {
            switch (random.nextInt(3)) {
                case 0: shapes[i] = new Circle();
                    break;
                case 1: shapes[i] = new Square();
                    break;
                case 2: shapes[i] = new Triangle();
                    break;
            }
        }
        for (Shape s : shapes) {
            s.draw();
            s.earse();
        }
    }
    public static void main(String[] args) {
        new ShapeTest();
    }
}

