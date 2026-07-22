package solutions.week3.lesson8;

import java.util.*;

public class Lab1SetImplementations {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "London", "Paris", "New York", "Beijing", "Paris", "London", "Toronto"
        );

        Set<String> hashSet = new HashSet<>(cities);
        Set<String> linkedHashSet = new LinkedHashSet<>(cities);
        Set<String> treeSet = new TreeSet<>(cities);

        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);

        System.out.println("\nContains Paris?");
        System.out.println("HashSet: " + hashSet.contains("Paris"));
        System.out.println("LinkedHashSet: " + linkedHashSet.contains("Paris"));
        System.out.println("TreeSet: " + treeSet.contains("Paris"));

        hashSet.remove("New York");
        linkedHashSet.remove("New York");
        treeSet.remove("New York");

        System.out.println("\nAfter removing New York:");
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);

        System.out.println("\nFinal sizes:");
        System.out.println("HashSet size: " + hashSet.size());
        System.out.println("LinkedHashSet size: " + linkedHashSet.size());
        System.out.println("TreeSet size: " + treeSet.size());
    }
}