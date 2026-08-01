package ca.qc.vc.week5.lesson13;

import java.util.List;

public class StreamTerminalOperations {
    List<Integer> numbers = List.of(5, 2, 8, 2, 1, 6);
    List<String> names = List.of("Amy", "David", "Alice", "Bob", "David");

    void matchMethods(){
        boolean anyMatchResult = numbers.stream()
                .anyMatch(number -> number > 7);
        boolean allMatchResult = numbers.stream()
                .allMatch(number -> number > 0);
        boolean noMatchResult = numbers.stream()
                .noneMatch(number -> number < 0);
        System.out.println(anyMatchResult + " " +  allMatchResult + " " +  noMatchResult);
//        System.out.println(Boolean.toString(anyMatchResult) + Boolean.toString(allMatchResult) + Boolean.toString(noMatchResult));
    }

    void forEach() {
        // using regular Lambda expression
        numbers.forEach(e->System.out.println(e + ", "));
        // using Method References !!!
        numbers.forEach(System.out::println);

    }
    void minMax() {
        int minimum = numbers.stream()
                .min((a, b) -> Integer.compare(a, b))
                .orElseThrow();

        int maximum = numbers.stream()
                .max((a, b) -> Integer.compare(a, b))
                .orElseThrow();
    }

    void count(){
        long count = numbers.stream()
                .filter(number -> number % 2 == 0)
                .count();

        System.out.println(count);
    }



    public static void main(String[] args) {
        new StreamTerminalOperations().matchMethods();
    }
}
