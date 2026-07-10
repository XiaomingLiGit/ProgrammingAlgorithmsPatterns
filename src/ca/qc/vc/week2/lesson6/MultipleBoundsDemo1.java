package ca.qc.vc.week2.lesson6;

public class MultipleBoundsDemo1 {

    public static <T extends Number & Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {
        Integer x = max(10, 20);
        Double y = max(3.5, 2.8);

        System.out.println(x);
        System.out.println(y);
    }
}