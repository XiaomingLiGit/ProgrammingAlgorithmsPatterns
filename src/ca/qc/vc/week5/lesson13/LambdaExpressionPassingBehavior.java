package ca.qc.vc.week5.lesson13;

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class LambdaExpressionPassingBehavior {
    static int performCalculation(int a, int b, Calculator operation) {
        return operation.calculate(a, b);
    }

    public static void main(String[] args) {
        // addition
        int result1 = performCalculation(10, 5, (a, b) -> a + b);
        // substraction
        int result2 = performCalculation(10, 5, (a, b) -> a - b);
        // multiplication
        int result3 = performCalculation(10, 5, (a, b) -> a * b);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
