package ca.qc.vc.week5.lesson13;

import java.util.List;

public class StreamMap {
    public static void main(String[] args) {
        List<Integer> numbers =
                List.of(5, 2, 8, 2, 1, 6);
        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .toList();
        System.out.println(squares);

        List<String> names =
                List.of("Amy", "David", "Alice", "Bob", "David");
        List<Integer> lengths = names.stream()
                .map(name -> name.length())
                .toList();
        System.out.println(lengths);
    }
}
