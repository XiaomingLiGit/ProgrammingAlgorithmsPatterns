package ca.qc.vc.week5.lesson14;

import java.util.List;

public class ParallelStream {
    List<Integer> numbers = List.of(5, 2, 8, 2, 1, 6);

    void sequentialAddition() {
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    void parallelAddition() {
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    void sequentialSubstraction() {
        int sum = numbers.stream().reduce(0, (a, b) -> a - b);
        System.out.println(sum);
    }

    void parallelSubstraction() {
        int sum = numbers.parallelStream()
                .reduce(0, (a, b) -> a - b);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        new ParallelStream().sequentialAddition();
        new ParallelStream().parallelAddition();
        new ParallelStream().sequentialSubstraction();
        new ParallelStream().parallelSubstraction();
    }
}
