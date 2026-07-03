package ca.qc.vc.week4.lesson12;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.Map;


public class StreamProcessExampleTest {
    public static void streamFilterExample() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(oddNumbers); // Output: [1, 3, 5, 7, 9]
    }

    public static void streamMaxExample() {
        List<String> words = List.of("apple", "banana", "cherry", "date");
        Optional<String> longestWord = words.stream()
                .max((w1, w2) -> w1.length() - w2.length());
        longestWord.ifPresent(System.out::println); // Output: banana
    }

    public static void streamReduceExample () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum); // Output: 15
    }

    public static void streamGroupingExample () {
        List<String> words = List.of("cat", "dog", "elephant", "bee", "ant");
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);
        // Output: {3=[cat, dog, bee, ant], 8=[elephant]}
    }

    public static void streamJoiningExample () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        String result = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(result); // Output: Alice, Bob, Charlie
    }

    public static void streamDuplicateExample () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 2, 5, 6, 3, 7);
        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicates); // Output: [2, 3]
    }

    public static void streamSortingExample () {
        List<String> words = List.of("apple", "banana", "fig", "cherry");
        List<String> sortedByLength = words.stream()
                .sorted((w1, w2) -> Integer.compare(w1.length(), w2.length()))
                .toList();
        System.out.println(sortedByLength);
        // Output: [fig, apple, banana, cherry]
    }

    public static void streamSkipLimitExample  () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> result = numbers.stream()
                .skip(2)  // Skip first 2 numbers
                .limit(3) // Limit to next 3 numbers
                .toList();
        System.out.println(result); // Output: [3, 4, 5]
    }

    public static void streamCountExample  () {
        List<Integer> numbers = List.of(1, 2, 6, 8, 10, 3);
        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println(count); // Output: 3
    }

    public static void parallelStreamExample  () {
        int sum = IntStream.range(1, 1000)
                .parallel() // Parallel processing
                .sum();
        System.out.println(sum); // Output: 499500
    }
}
