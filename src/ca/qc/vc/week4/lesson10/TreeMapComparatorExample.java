package ca.qc.vc.week4.lesson10;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparatorExample {
    public static void main(String[] args) {

        Comparator<Integer> descendingOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(b, a); // descending order
            }
        };

        TreeMap<Integer, String> students = new TreeMap<>(descendingOrder);

        students.put(1001, "Alice");
        students.put(1003, "Charlie");
        students.put(1002, "Bob");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}