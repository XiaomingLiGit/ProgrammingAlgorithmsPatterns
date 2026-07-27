package solutions.midterm;

import java.util.*;

public class WordCounter {
    public static Map<String, Integer> wordFrequency(String sentence) {
        Map<String, Integer> freq = new HashMap<>();
        if (sentence == null) return freq;

        String[] words = sentence.toLowerCase().trim().split("\s+");
        for (String word : words) {
            if (word.isEmpty()) continue;
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }

    public static String mostFrequent(Map<String, Integer> freq) {
        String bestWord = null;
        int bestCount = -1;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > bestCount) {
                bestWord = entry.getKey();
                bestCount = entry.getValue();
            }
        }
        return bestWord;



    }


}
