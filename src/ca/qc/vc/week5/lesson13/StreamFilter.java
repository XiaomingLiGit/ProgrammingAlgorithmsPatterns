package ca.qc.vc.week5.lesson13;

import java.util.List;

public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> numbers =
                List.of(5, 2, 8, 2, 1, 6);
        //  Like WHERE number % 2 = 0 in SQL
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        System.out.println(evenNumbers);
    }
}
