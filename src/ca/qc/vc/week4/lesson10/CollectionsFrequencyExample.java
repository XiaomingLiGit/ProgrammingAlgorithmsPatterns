package ca.qc.vc.week4.lesson10;

import java.util.*;

public class CollectionsFrequencyExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David");

        int count = Collections.frequency(names, "Alice");

        System.out.println(count);
    }
}