package ca.qc.vc.week5.lesson14;

import java.util.List;
import java.util.Optional;

public class StreamReduction3 {

    static void reduction1(){
        List<Integer> scores = List.of(78, 92, 85, 96, 88);

        Optional<Integer> highestScore = scores.stream()
                .reduce(Integer::max);

        highestScore.ifPresent(
                score -> System.out.println("Highest score: " + score)
        );

    }

    static void reduction2(){
        List<Integer> quantities = List.of(20, 15, 30, 10);

        int totalQuantity = quantities.stream()
                .reduce(0, Integer::sum);

        System.out.println("Total quantity: " + totalQuantity);
    }

    static void reduction3(){
        List<String> words = List.of(
                "Java",
                "Stream",
                "Programming"
        );

        int totalCharacters = words.parallelStream()
                .reduce(
                        0,
                        (subtotal, word) -> subtotal + word.length(),
                        Integer::sum
                );

        System.out.println("Total characters: " + totalCharacters);
    }

    public static void main(String[] args) {
        reduction3();
    }
}
