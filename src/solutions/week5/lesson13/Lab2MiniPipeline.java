package solutions.week5.lesson13;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Lab2MiniPipeline {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Alice",
                "Bob",
                "Charlotte",
                "David",
                "Eva",
                "Frank",
                "Grace"
        );

        names.stream()

                // Keep names with at least five characters
                .filter(name -> name.length() >= 5)

                // Convert names to uppercase
                .map(name ->
                        name.toUpperCase(Locale.ROOT))

                // Sort alphabetically
                .sorted()

                // Print using a method reference
                .forEach(System.out::println);
    }
}