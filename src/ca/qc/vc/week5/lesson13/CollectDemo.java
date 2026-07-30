package ca.qc.vc.week5.lesson13;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectDemo {
    public static void main(String[] args) {
        String[] names = {"Jamal", "Peter", "Soraya", "Kim", "Imani",
                "Giorgio", "Alan", "Stacy", "Michelle", "jamal"};
        System.out.println("The number of characters for all names: " +
                Stream.of(names).parallel().collect(StringBuilder::new,
                        StringBuilder::append, StringBuilder::append).length());

        List<String> list = Stream.of(names).collect(ArrayList::new,
                ArrayList::add, ArrayList::addAll);
        System.out.println(list);

        list = Stream.of(names).collect(Collectors.toList());
        System.out.println(list);

        Set<String> set = Stream.of(names).map(e -> e.toUpperCase()).
                collect(Collectors.toSet());
        System.out.println(set);

        Map<String, Integer> map = Stream.of(names).collect(
                Collectors.toMap(e -> e, e -> e.length()));
        System.out.println(map);

        System.out.println("The total number of characters is " +
                Stream.of(names).
                        collect(Collectors.summingInt(e -> e.length())));

        java.util.IntSummaryStatistics stats = Stream.of(names).
                collect(Collectors.summarizingInt(e -> e.length()));
        System.out.println("Max is " + stats.getMax());
        System.out.println("Min is " + stats.getMin());
        System.out.println("Average is " + stats.getAverage());
    }
}