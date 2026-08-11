package solutions.week5.lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lab1RefactorToLambdas {

    public static void main(String[] args) {

        /*
         * 1. Runnable
         * Target functional interface: Runnable
         * Abstract method: void run()
         */

        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        "Running from the anonymous class."
                );
            }
        };

        Runnable lambdaRunnable = () ->
                System.out.println(
                        "Running from the lambda expression."
                );

        anonymousRunnable.run();
        lambdaRunnable.run();

        /*
         * 2. Comparator<String>
         * Target functional interface: Comparator<String>
         * Abstract method: int compare(String first, String second)
         */

        Comparator<String> anonymousComparator =
                new Comparator<String>() {
                    @Override
                    public int compare(
                            String first,
                            String second) {

                        return Integer.compare(
                                first.length(),
                                second.length()
                        );
                    }
                };

        Comparator<String> lambdaComparator =
                (first, second) ->
                        Integer.compare(
                                first.length(),
                                second.length()
                        );

        List<String> originalNames =
                new ArrayList<>(Arrays.asList(
                        "Christopher",
                        "Bob",
                        "Alice",
                        "David"
                ));

        List<String> lambdaNames =
                new ArrayList<>(originalNames);

        originalNames.sort(anonymousComparator);
        lambdaNames.sort(lambdaComparator);

        System.out.println(
                "\nAnonymous comparator: " + originalNames
        );

        System.out.println(
                "Lambda comparator:    " + lambdaNames
        );

        System.out.println(
                "Same sorting result: "
                        + originalNames.equals(lambdaNames)
        );

        /*
         * 3. Predicate<Integer>
         * Target functional interface: Predicate<Integer>
         * Abstract method: boolean test(Integer value)
         */

        Predicate<Integer> anonymousPredicate =
                new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer number) {
                        return number % 2 == 0;
                    }
                };

        Predicate<Integer> lambdaPredicate =
                number -> number % 2 == 0;

        List<Integer> numbers =
                Arrays.asList(3, 4, 7, 10, 15, 18);

        boolean samePredicateResult =
                numbers.stream()
                        .allMatch(number ->
                                anonymousPredicate.test(number)
                                        == lambdaPredicate.test(number)
                        );

        System.out.println(
                "\nEven numbers:"
        );

        numbers.stream()
                .filter(lambdaPredicate)
                .forEach(System.out::println);

        System.out.println(
                "Same predicate behavior: "
                        + samePredicateResult
        );
    }
}
