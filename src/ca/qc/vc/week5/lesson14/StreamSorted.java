package ca.qc.vc.week5.lesson14;

import java.util.List;

public class StreamSorted {
    public static void main(String[] args) {
        List<Integer> numbers =
                List.of(5, 2, 8, 2, 1, 6);
        List<Integer> descending = numbers.stream()
                .sorted((a, b) -> Integer.compare(b, a))
                .toList();

        System.out.println(descending);


        List<String> names =
                List.of("Amy", "David", "Alice", "Bob", "David");
        List<String> sortedNames = names.stream()
                .sorted(
                        (first, second) ->
                                Integer.compare(
                                        first.length(),
                                        second.length()
                                )
                ).toList();

        System.out.println(sortedNames);

    }
}
