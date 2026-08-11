package solutions.week5.lesson14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Lab5ShoppingCartReduction {

    static class CartItem {
        private final String productName;
        private final int priceInCents;
        private final int quantity;

        public CartItem(
                String productName,
                int priceInCents,
                int quantity) {

            this.productName = productName;
            this.priceInCents = priceInCents;
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public long getLineValueInCents() {
            return (long) priceInCents * quantity;
        }
    }

    public static String formatCents(long cents) {
        return String.format("$%,.2f", cents / 100.0);
    }

    public static void analyzeCart(
            String cartName,
            List<CartItem> cart) {

        System.out.println("\n--- " + cartName + " ---");

        /*
         * reduce(identity, accumulator)
         *
         * Identity: 0
         * Accumulator: Integer::sum
         */
        int totalQuantity =
                cart.stream()
                        .map(CartItem::getQuantity)
                        .reduce(0, Integer::sum);

        /*
         * reduce(accumulator)
         *
         * No identity value.
         * Returns Optional<CartItem>.
         */
        Optional<CartItem> highestValueItem =
                cart.stream()
                        .reduce((first, second) ->
                                first.getLineValueInCents()
                                        >= second.getLineValueInCents()
                                        ? first
                                        : second
                        );

        String highestValueDescription =
                highestValueItem
                        .map(item ->
                                item.getProductName()
                                        + " — "
                                        + formatCents(
                                        item.getLineValueInCents()
                                ))
                        .orElse("None");

        /*
         * Three-argument reduce()
         *
         * Identity: 0L
         * Accumulator: add each item's line value
         * Combiner: Long::sum
         */
        long totalCartValue =
                cart.parallelStream()
                        .reduce(
                                0L,
                                (subtotal, item) ->
                                        subtotal
                                                + item.getLineValueInCents(),
                                Long::sum
                        );

        System.out.println(
                "Total quantity: " + totalQuantity
        );

        System.out.println(
                "Highest-value item: "
                        + highestValueDescription
        );

        System.out.println(
                "Total cart value: "
                        + formatCents(totalCartValue)
        );
    }

    public static void main(String[] args) {
        List<CartItem> populatedCart = Arrays.asList(
                new CartItem("Laptop Stand", 4999, 1),
                new CartItem("Wireless Mouse", 2599, 2),
                new CartItem("Keyboard", 6999, 1),
                new CartItem("USB Cable", 1299, 3)
        );

        List<CartItem> emptyCart =
                Collections.emptyList();

        analyzeCart("Populated Cart", populatedCart);
        analyzeCart("Empty Cart", emptyCart);
    }
}