package ca.qc.vc.week5.lesson13;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReductionDemo {
    public static void main(String[] args) {
        int[] values = {3, 4, 1, 5, 20, 1, 3, 3, 4, 6};

        System.out.print("The values are ");
        IntStream.of(values).forEach(e -> System.out.print(e + " "));

        System.out.println("\nThe result of multiplying all values is " +
                IntStream.of(values).parallel().reduce(1, (e1, e2) -> e1 * e2));

        System.out.print("The values are " +
                IntStream.of(values).mapToObj(e -> e + "")
                        .reduce((e1, e2) -> e1 + ", " + e2).get());

        String[] names = {"Jamal", "Peter", "Soraya", "Kim", "Imani",
                "Giorgio", "Alan", "Stacy", "Michelle", "jamal"};
        System.out.print("\nThe names are: ");
        System.out.println(Stream.of(names)
                .reduce((x, y) -> x + ", " + y).get());

        System.out.print("Concat names: ");
        System.out.println(Stream.of(names)
                .reduce((x, y) -> x + y).get());

        System.out.print("Total number of characters: ");
        System.out.println(Stream.of(names)
                .reduce((x, y) -> x + y).get().length());
    }
}