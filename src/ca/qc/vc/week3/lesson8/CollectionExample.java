package ca.qc.vc.week3.lesson8;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits: " + fruits);
        System.out.println("Contains Banana? " + fruits.contains("Banana"));
        System.out.println("Size: " + fruits.size());

        fruits.remove("Orange");
        System.out.println("After removal: " + fruits);
    }
}