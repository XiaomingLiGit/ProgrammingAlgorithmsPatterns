package ca.qc.vc.week6.lesson17;
import java.util.*;

public class GAFractionalKnapsack {
    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public double ratio() {
            return (double) value / weight;
        }
    }

    public static double maxValue(Item[] items, int capacity) {
        // Sort by value-to-weight ratio in descending order
        Arrays.sort(
                items,
                (a, b) -> Double.compare(b.ratio(), a.ratio())
        );

        double total = 0.0;
        int remaining = capacity;

        for (Item item : items) {

            if (remaining == 0) {
                break;
            }

            // Take the whole item or part of it
            int taken = Math.min(remaining, item.weight);

            total += taken * item.ratio();

            remaining -= taken;
        }

        return total;
    }

    public static void main(String[] args) {

        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        int capacity = 50;

        double result = maxValue(items, capacity);

        System.out.println("Maximum value = " + result);
    }
}