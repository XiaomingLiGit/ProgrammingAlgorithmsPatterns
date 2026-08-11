package solutions.week5.lesson13;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Lab3PracticeLambdaForms {

    public static void main(String[] args) {

        /*
         * 1. No parameters
         * Functional interface: Runnable
         * Interface method: run()
         */
        Runnable printMessage =
                () -> System.out.println("Hello Java");

        /*
         * 2. One parameter
         * Functional interface: Function<Integer, Integer>
         * Interface method: apply()
         */
        Function<Integer, Integer> square =
                number -> number * number;

        /*
         * 3. Two parameters
         * Functional interface: BinaryOperator<Integer>
         * Interface method: apply()
         */
        BinaryOperator<Integer> add =
                (first, second) -> first + second;

        /*
         * 4. Block lambda
         * Functional interface: BinaryOperator<Integer>
         */
        BinaryOperator<Integer> maximum =
                (first, second) -> {
                    if (first >= second) {
                        return first;
                    } else {
                        return second;
                    }
                };

        // Execute each lambda using its interface method
        printMessage.run();

        System.out.println(
                "Square of 6: " + square.apply(6)
        );

        System.out.println(
                "10 + 20 = " + add.apply(10, 20)
        );

        System.out.println(
                "Larger value: " + maximum.apply(35, 28)
        );
    }
}