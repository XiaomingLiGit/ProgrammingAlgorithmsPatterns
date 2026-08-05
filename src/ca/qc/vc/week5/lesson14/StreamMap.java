package ca.qc.vc.week5.lesson14;

import java.util.List;
import java.util.function.Function;

public class StreamMap {
    public static void main(String[] args) {
        List<Integer> numbers =
                List.of(5, 2, 8, 2, 1, 6);
        List<Integer> squares = numbers.stream()
                .map(number -> number * number)
                .toList();

//        List<Integer> squares = numbers.stream()
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer number) {
//                        return number * number;
//                    }
//                })
//                .toList();


        System.out.println(squares);


        List<String> names =
                List.of("Amy", "David", "Alice", "Bob", "David");
        List<Integer> lengths = names.stream()
                .map(name -> name.length())
                .toList();
        System.out.println(lengths);
    }
}
