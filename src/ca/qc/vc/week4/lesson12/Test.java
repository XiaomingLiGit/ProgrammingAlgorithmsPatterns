package ca.qc.vc.week4.lesson12;

import java.util.*;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {

        Double[] numbers = {2.4, 55.6, 90.12, 26.6};       //  data source
        Set<Double> set = new HashSet<>(Arrays.asList(numbers));   // convert to a set

//        int count = 0;
//        for (double e: set)
//            if (e > 60)  count++;                       // condition
//        System.out.println("Count is " + count);


        //  using Java stream processing since Java 8.
        //  Basic steps:
        //  1. convert the set into a stream
        //  2. filter() with condition: e > 60
        //  3. count(), which is an aggregate function
        System.out.println("Count is "  + set.stream().filter (e->e>60). count());

        // repeat the process above without Lambda Expression
        // using inner class (Anonymous class)
//        System.out.println("Count is "  + set.stream().filter(new Predicate<Double>() {
//            @Override
//            public boolean test(Double e) {
//                if (e > 60)
//                        return true;
//                return false;
//            }
//        }).count());
    }
}
