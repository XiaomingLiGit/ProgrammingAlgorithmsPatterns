package ca.qc.vc.week5.lesson14;

import java.util.List;
import java.util.function.Predicate;

public class StreamStrategyDemo {

    // Context: the Stream pipeline remains unchanged
    public static List<Integer> select(
            List<Integer> numbers,
            Predicate<Integer> strategy) {

        return numbers.stream()
                .filter(strategy)
                .toList();
    }

    public static void main(String[] args) {

        List<Integer> numbers =
                List.of(1, 2, 3, 4, 5, 6);

        // Concrete Strategy 1
        Predicate<Integer> evenStrategy =
                number -> number % 2 == 0;

        // Concrete Strategy 2
        Predicate<Integer> greaterThanThreeStrategy =
                number -> number > 3;

        System.out.println(
                "Even numbers: "
                        + select(numbers, evenStrategy));

        System.out.println(
                "Greater than 3: "
                        + select(numbers, greaterThanThreeStrategy));
    }
}