package solutions.week6.lesson17;

import java.util.Arrays;

public class Lab3AssignCookies {

    public static int assignCookies(
            int[] greedFactors, int[] cookieSizes) {

        Arrays.sort(greedFactors);
        Arrays.sort(cookieSizes);

        int child = 0;
        int cookie = 0;

        while (child < greedFactors.length
                && cookie < cookieSizes.length) {

            if (cookieSizes[cookie] >= greedFactors[child]) {
                System.out.println(
                        "Child requiring "
                                + greedFactors[child]
                                + " receives cookie "
                                + cookieSizes[cookie]
                );

                child++;
            }

            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {
        int[] greedFactors = {1, 2, 3};
        int[] cookieSizes = {1, 1, 2, 3};

        int satisfiedChildren =
                assignCookies(greedFactors, cookieSizes);

        System.out.println(
                "Number of satisfied children: "
                        + satisfiedChildren
        );
    }
}
