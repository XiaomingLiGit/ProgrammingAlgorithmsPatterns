package solutions.week5.lesson13;

@FunctionalInterface
interface MathOperation {

    double calculate(double a, double b);
}

public class Lab5MiniCalculator {

    public static void displayResult(
            String operationName,
            MathOperation operation,
            double a,
            double b) {

        double result = operation.calculate(a, b);

        System.out.printf(
                "%-15s %.2f%n",
                operationName + ":",
                result
        );
    }

    public static void main(String[] args) {

        MathOperation addition =
                (a, b) -> a + b;

        MathOperation subtraction =
                (a, b) -> a - b;

        MathOperation multiplication =
                (a, b) -> a * b;

        MathOperation division =
                (a, b) -> {
                    if (b == 0) {
                        throw new IllegalArgumentException(
                                "Cannot divide by zero."
                        );
                    }

                    return a / b;
                };

        MathOperation maximum =
                (a, b) -> a >= b ? a : b;

        MathOperation minimum =
                (a, b) -> a <= b ? a : b;

        double firstNumber = 20;
        double secondNumber = 5;

        displayResult(
                "Addition",
                addition,
                firstNumber,
                secondNumber
        );

        displayResult(
                "Subtraction",
                subtraction,
                firstNumber,
                secondNumber
        );

        displayResult(
                "Multiplication",
                multiplication,
                firstNumber,
                secondNumber
        );

        displayResult(
                "Division",
                division,
                firstNumber,
                secondNumber
        );

        displayResult(
                "Maximum",
                maximum,
                firstNumber,
                secondNumber
        );

        displayResult(
                "Minimum",
                minimum,
                firstNumber,
                secondNumber
        );
    }
}