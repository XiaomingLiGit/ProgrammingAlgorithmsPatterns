package ca.qc.vc.week5.lesson14;

import java.util.*;

public class Stream {
    public static void main(String[] args){
        Double[] numbers = {2.4, 55.6, 90.12, 26.6};
        Set<Double> set = new HashSet<>(Arrays.asList(numbers));
        int count = 0;
        for (double e: set)
            if (e > 60)  count++;
        System.out.println("Count is " + count);

        //   arrange the set in a data stream, filter the stream, and compute the count
        System.out.println("Count is "  + set.stream().filter (e -> e>60). count());


//        Predicate<Double> isEven = e -> (e % 2 == 0);
    }


}
