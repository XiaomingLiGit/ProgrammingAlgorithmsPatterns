package ca.qc.vc.week5.lesson14;

import java.util.List;

public class StreamCreate {
    public static void main(String[] args) {

    }
    static void collectionStreamCreate() {
        List<String> names =
                List.of("Amy", "David", "Alice", "Bob", "David");
        //                  collection.stream()
        List<String> result = names.stream()     // source
                .filter(name -> name.length() > 3) // intermediate
                .map(name -> name.toUpperCase())   // intermediate
                .sorted()                          // intermediate
                .toList();                         // terminal

        System.out.println(result);
    }


}
