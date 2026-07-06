package ca.qc.vc.week1.lesson1;

import java.util.ArrayList;
import java.util.List;

public class AutoboxExamples {
    public static void main(String[] args) {
        // 1. use the wrapper classes instead of primivtive types
        List<Integer> scores_list = new ArrayList<>();

        // 2. autoboxing mechamism, you can insert a primivtive value
        // it can be converted automatically
        scores_list.add(99);
        scores_list.add(88);
        scores_list.add(77);


        // 3.
        int value = scores_list.get(0);
        System.out.println(value);
    }
}
