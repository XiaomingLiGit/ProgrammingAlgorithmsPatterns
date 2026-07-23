package ca.qc.vc.week4.lesson10;

import java.util.*;

public class CollectionsComparatorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Tom", "Alexander", "Bob", "Chris"));

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        System.out.println(names);
    }
}