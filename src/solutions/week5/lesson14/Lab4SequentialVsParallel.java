package solutions.week5.lesson14;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lab4SequentialVsParallel {

    private static final int NUMBER_OF_RUNS = 5;

    public static List<Integer> generateNumbers(int size) {
        return IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());
    }

    public static long sequentialSumOfSquares(
            List<Integer> numbers) {

        return numbers.stream()
                .mapToLong(number ->
                        (long) number * number)
                .sum();
    }

    public static long parallelSumOfSquares(
            List<Integer> numbers) {

        return numbers.parallelStream()
                .mapToLong(number ->
                        (long) number * number)
                .sum();
    }

    public static void benchmark(
            String dataSetName,
            List<Integer> numbers) {

        // Warm-up runs
        sequentialSumOfSquares(numbers);
        parallelSumOfSquares(numbers);

        long sequentialResult = 0;

        long sequentialStart = System.nanoTime();

        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            sequentialResult =
                    sequentialSumOfSquares(numbers);
        }

        long sequentialEnd = System.nanoTime();

        long parallelResult = 0;

        long parallelStart = System.nanoTime();

        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            parallelResult =
                    parallelSumOfSquares(numbers);
        }

        long parallelEnd = System.nanoTime();

        double sequentialAverage =
                (sequentialEnd - sequentialStart)
                        / 1_000_000.0
                        / NUMBER_OF_RUNS;

        double parallelAverage =
                (parallelEnd - parallelStart)
                        / 1_000_000.0
                        / NUMBER_OF_RUNS;

        System.out.println("\nData set: " + dataSetName);
        System.out.println("Size: " + numbers.size());

        System.out.println(
                "Sequential result: " + sequentialResult
        );

        System.out.println(
                "Parallel result:   " + parallelResult
        );

        System.out.println(
                "Same result: "
                        + (sequentialResult == parallelResult)
        );

        System.out.printf(
                "Sequential average time: %.3f ms%n",
                sequentialAverage
        );

        System.out.printf(
                "Parallel average time:   %.3f ms%n",
                parallelAverage
        );
    }

    public static void main(String[] args) {
        System.out.println(
                "Available processors: "
                        + Runtime.getRuntime()
                        .availableProcessors()
        );

        List<Integer> smallData =
                generateNumbers(10_000);

        List<Integer> largeData =
                generateNumbers(2_000_000);

        benchmark("Small data set", smallData);
        benchmark("Large data set", largeData);

        System.out.println("\nInterpretation:");

        System.out.println(
                "- Parallel streams may help with large data sets."
        );

        System.out.println(
                "- They work best when each element requires "
                        + "expensive computation."
        );

        System.out.println(
                "- For small or simple tasks, splitting and "
                        + "combining work may make parallel "
                        + "execution slower."
        );
    }
}