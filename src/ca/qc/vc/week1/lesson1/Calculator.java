package ca.qc.vc.week1.lesson1;

public class Calculator {

    // Overload by number of parameters
    public int add(int a, int b) {
        return a + b;
    }

    // Overload by type of parameters
    public double add(double a, double b) {
        return a + b;
    }

    // Overload by number AND type
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overload by order of parameters
    public String add(String s, int times) {
        return s.repeat(times);
    }

    public String add(int times, String s) {
        // Different parameter order — also valid
        return s.repeat(times);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(calc.add(2, 3));          // calls add(int, int)
        System.out.println(calc.add(2.5, 4.1));      // calls add(double, double)
        System.out.println(calc.add(1, 2, 3));       // calls add(int, int, int)
        System.out.println(calc.add("Hi", 3));       // calls add(String, int)
        System.out.println(calc.add(3, "Bye"));      // calls add(int, String)
    }
}