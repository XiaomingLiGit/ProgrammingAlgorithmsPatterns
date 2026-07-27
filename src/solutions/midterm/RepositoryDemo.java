package solutions.midterm;

import java.util.*;

class Repository<K, V> {
    private Map<K, V> data = new HashMap<>();

    public void save(K key, V value) {
        data.put(key, value);
    }

    public V find(K key) {
        return data.get(key);
    }

    public V remove(K key) {
        return data.remove(key);
    }

    public boolean contains(K key) {
        return data.containsKey(key);
    }

    public int size() {
        return data.size();
    }
}

public class RepositoryDemo {
    public static void main(String[] args) {
        Repository<String, String> products = new Repository<>();
        products.save("SKU-101", "Keyboard");
        products.save("SKU-102", "Mouse");
        products.save("SKU-103", "Monitor");

        System.out.println(products.find("SKU-102"));
        System.out.println(products.contains("SKU-101"));
        products.remove("SKU-103");
        System.out.println(products.size());
    }
}
