package ca.qc.vc.week4.lesson10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        map.put("1", "Tom");
        map.put("2", "Jerry");
        map.put("3", "Spike");
        map.put("1", "Tom");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, String> item = iterator.next();

            String key = item.getKey();
            String value = item.getValue();

            System.out.println(key + " ... " + value);
        }

        // An alternative way to iterate over a map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey() + " ... " + entry.getValue()
            );
        }
    }
}