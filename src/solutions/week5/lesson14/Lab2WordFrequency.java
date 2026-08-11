package solutions.week5.lesson14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab2WordFrequency {

    private static final Set<String> STOP_WORDS =
            new HashSet<>(Arrays.asList(
                    "a", "an", "the", "and", "or", "but",
                    "is", "are", "was", "were",
                    "to", "of", "in", "on", "for",
                    "with", "as", "at", "by"
            ));

    public static void main(String[] args)
            throws IOException {

        Path filePath;

        if (args.length > 0) {
            filePath = Paths.get(args[0]);
        } else {
            filePath = Paths.get("input.txt");
        }

        if (!Files.exists(filePath)) {
            System.out.println(
                    "File not found: "
                            + filePath.toAbsolutePath()
            );
            return;
        }

        Map<String, Long> wordFrequencies;

        // Files.lines() must be closed after processing
        try (Stream<String> lines = Files.lines(
                filePath,
                StandardCharsets.UTF_8)) {

            wordFrequencies = lines

                    // Split every line into individual words
                    .flatMap(line ->
                            Arrays.stream(line.split("\\s+")))

                    // Convert to lowercase and remove punctuation
                    .map(word ->
                            word.toLowerCase()
                                    .replaceAll(
                                            "[^\\p{L}\\p{N}]",
                                            ""
                                    ))

                    // Remove empty strings
                    .filter(word -> !word.isEmpty())

                    // Remove common stop words
                    .filter(word ->
                            !STOP_WORDS.contains(word))

                    // Count the frequency of each word
                    .collect(
                            Collectors.groupingBy(
                                    Function.identity(),
                                    Collectors.counting()
                            )
                    );
        }

        System.out.println(
                "The ten most frequent words:"
        );

        wordFrequencies.entrySet()
                .stream()
                .sorted((first, second) -> {
                    int frequencyComparison =
                            Long.compare(
                                    second.getValue(),
                                    first.getValue()
                            );

                    if (frequencyComparison != 0) {
                        return frequencyComparison;
                    }

                    return first.getKey()
                            .compareTo(second.getKey());
                })
                .limit(10)
                .forEach(entry ->
                        System.out.printf(
                                "%-20s %d%n",
                                entry.getKey(),
                                entry.getValue()
                        ));
    }
}