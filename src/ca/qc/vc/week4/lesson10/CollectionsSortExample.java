package ca.qc.vc.week4.lesson10;

import java.util.*;

public class CollectionsSortExample {
    public static void main(String[] args) {
        List<Integer> scores = new ArrayList<>(Arrays.asList(90, 70, 85, 100));

        Collections.sort(scores);

        System.out.println(scores);
    }
}