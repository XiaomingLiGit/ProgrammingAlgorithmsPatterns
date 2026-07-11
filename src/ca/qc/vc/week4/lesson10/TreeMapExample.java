package ca.qc.vc.week4.lesson10;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> schedule = new TreeMap<>();

        // Add deliveries in an unsorted order
        schedule.put(1400, "Delivery to Toronto");
        schedule.put(900, "Delivery to Montreal");
        schedule.put(1600, "Delivery to Ottawa");
        schedule.put(1100, "Delivery to Quebec City");

        // TreeMap automatically sorts entries by key
        System.out.println("Delivery schedule:");

        for (Map.Entry<Integer, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Get the earliest and latest deliveries
        System.out.println("\nEarliest delivery: " + schedule.firstEntry());
        System.out.println("Latest delivery: " + schedule.lastEntry());

        // Find the next delivery at or after 12:00
        System.out.println(
                "Next delivery after 12:00: "
                        + schedule.ceilingEntry(1200)
        );

        // Display all deliveries before 14:00
        System.out.println(
                "Deliveries before 14:00: "
                        + schedule.headMap(1400, false)
        );

        // Remove a delivery
        schedule.remove(1100);

        System.out.println("After removal: " + schedule);
    }
}