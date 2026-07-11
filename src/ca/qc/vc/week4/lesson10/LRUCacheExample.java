package ca.qc.vc.week4.lesson10;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheExample {

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {

        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "Alice");
        cache.put(2, "Bob");
        cache.put(3, "Charlie");

        System.out.println("Initial cache: " + cache);

        cache.get(1);
        System.out.println("After accessing key 1: " + cache);

        cache.put(4, "David");
        System.out.println("After adding key 4: " + cache);

        cache.get(3);
        cache.put(5, "Emily");

        System.out.println("Final cache: " + cache);
    }
}