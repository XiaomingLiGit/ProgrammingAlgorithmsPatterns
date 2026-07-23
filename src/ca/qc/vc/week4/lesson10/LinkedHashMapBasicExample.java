package ca.qc.vc.week4.lesson10;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapBasicExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> students = new LinkedHashMap<>();

        students.put(1001, "Alice");
        students.put(1002, "Bob");
        students.put(1003, "Charlie");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}