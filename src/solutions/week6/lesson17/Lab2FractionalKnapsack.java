package solutions.week6.lesson17;

import java.util.Arrays;

public class Lab2FractionalKnapsack {

    static class Item {
        String name;
        double weight;
        double value;

        Item(String name, double weight, double value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        double getValuePerUnitWeight() {
            return value / weight;
        }
    }

    public static double fractionalKnapsack(
            Item[] items, double capacity) {

        // Greedy choice: sort by value-to-weight ratio
        Arrays.sort(
                items,
                (item1, item2) -> Double.compare(
                        item2.getValuePerUnitWeight(),
                        item1.getValuePerUnitWeight()
                )
        );

        double remainingCapacity = capacity;
        double totalValue = 0;

        for (Item item : items) {
            if (remainingCapacity == 0) {
                break;
            }

            double fraction = Math.min(
                    1.0,
                    remainingCapacity / item.weight
            );

            double valueGained = fraction * item.value;

            totalValue += valueGained;
            remainingCapacity -= fraction * item.weight;

            System.out.printf(
                    "%s: take %.2f%%, value gained = %.2f%n",
                    item.name,
                    fraction * 100,
                    valueGained
            );
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item("Item 1", 10, 60),
                new Item("Item 2", 20, 100),
                new Item("Item 3", 30, 120)
        };

        double capacity = 50;

        double maximumValue =
                fractionalKnapsack(items, capacity);

        System.out.printf(
                "Maximum total value = %.2f%n",
                maximumValue
        );
    }
}