package ca.qc.vc.week4.lesson10;

import java.util.HashMap;
import java.util.Map;

public class MapCRUD {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        // Create
        scores.put("Alice", 90);
        scores.put("Bob", 85);

        // Read
        scores.get("Alice");
        scores.getOrDefault("David", 0);
        scores.containsKey("Bob");

        // Update
        scores.put("Alice", 95);
        scores.replace("Bob", 88);

        // Delete
        scores.remove("Alice");
        scores.clear();
    }
}
