package ca.qc.vc.week4.lesson10;

import java.util.*;

public class CollectionsReverseExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));

        Collections.reverse(names);

        System.out.println(names);
    }
}
