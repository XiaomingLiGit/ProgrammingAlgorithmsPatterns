package ca.qc.vc.week5.lesson14;

import java.util.List;
import java.util.function.Predicate;

public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> numbers =
                List.of(5, 2, 8, 2, 1, 6);
        //  Like WHERE number % 2 = 0 in SQL
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();


//        List<Integer> evenNumbers = numbers.stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                if(integer % 2 == 0)
//                    return true;
//                return false;
//            }
//        }).toList();


        System.out.println(evenNumbers);
    }
}
