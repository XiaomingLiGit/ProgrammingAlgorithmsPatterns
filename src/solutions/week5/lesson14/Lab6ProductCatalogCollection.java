package solutions.week5.lesson14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lab6ProductCatalogCollection {

    static class Product {
        private final String name;
        private final String category;
        private final double price;
        private final boolean available;

        public Product(
                String name,
                String category,
                double price,
                boolean available) {

            this.name = name;
            this.category = category;
            this.price = price;
            this.available = available;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public boolean isAvailable() {
            return available;
        }

        @Override
        public String toString() {
            return String.format(
                    "%-18s %-12s $%,.2f",
                    name,
                    category,
                    price
            );
        }
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product(
                        "Laptop", "Electronics", 1299.99, true),
                new Product(
                        "Mouse", "Electronics", 29.99, true),
                new Product(
                        "Keyboard", "Electronics", 79.99, false),
                new Product(
                        "Desk", "Furniture", 349.99, true),
                new Product(
                        "Chair", "Furniture", 249.99, false),
                new Product(
                        "Notebook", "Stationery", 5.99, true),
                new Product(
                        "Pen Set", "Stationery", 12.99, true)
        );

        // Collect all available products into a List
        List<Product> availableProducts =
                products.stream()
                        .filter(Product::isAvailable)
                        .collect(Collectors.toList());

        // Collect unique categories into a Set
        Set<String> categories =
                products.stream()
                        .map(Product::getCategory)
                        .collect(
                                Collectors.toCollection(
                                        TreeSet::new
                                )
                        );

        // Group products by category
        Map<String, List<Product>> productsByCategory =
                products.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Product::getCategory,
                                        TreeMap::new,
                                        Collectors.toList()
                                )
                        );

        // Calculate average price by category
        Map<String, Double> averagePriceByCategory =
                products.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Product::getCategory,
                                        TreeMap::new,
                                        Collectors.averagingDouble(
                                                Product::getPrice
                                        )
                                )
                        );

        // Partition into available and unavailable groups
        Map<Boolean, List<Product>> availabilityGroups =
                products.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        Product::isAvailable
                                )
                        );

        // Create a map from product name to price
        Map<String, Double> priceByProductName =
                products.stream()
                        .collect(
                                Collectors.toMap(
                                        Product::getName,
                                        Product::getPrice,
                                        (existingPrice, newPrice) ->
                                                existingPrice,
                                        TreeMap::new
                                )
                        );

        System.out.println("Available products:");

        availableProducts.forEach(System.out::println);

        System.out.println(
                "\nUnique categories: " + categories
        );

        System.out.println("\nProducts by category:");

        productsByCategory.forEach(
                (category, categoryProducts) -> {

                    String productNames =
                            categoryProducts.stream()
                                    .map(Product::getName)
                                    .collect(
                                            Collectors.joining(", ")
                                    );

                    System.out.println(
                            category + ": " + productNames
                    );
                }
        );

        System.out.println("\nAverage price by category:");

        averagePriceByCategory.forEach(
                (category, averagePrice) ->
                        System.out.printf(
                                "%-12s $%,.2f%n",
                                category,
                                averagePrice
                        )
        );

        System.out.println("\nAvailable group:");

        availabilityGroups.get(true)
                .forEach(System.out::println);

        System.out.println("\nUnavailable group:");

        availabilityGroups.get(false)
                .forEach(System.out::println);

        System.out.println("\nProduct name to price map:");

        priceByProductName.forEach(
                (name, price) ->
                        System.out.printf(
                                "%-18s $%,.2f%n",
                                name,
                                price
                        )
        );
    }
}