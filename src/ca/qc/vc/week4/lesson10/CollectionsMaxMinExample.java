package ca.qc.vc.week4.lesson10;

import java.util.*;

public class CollectionsMaxMinExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 45, 7, 30);

        System.out.println(Collections.max(numbers));
        System.out.println(Collections.min(numbers));
    }
}