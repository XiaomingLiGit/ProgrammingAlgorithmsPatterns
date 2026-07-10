package ca.qc.vc.week3.lesson9;


import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {

        HashSet<String> cities = new HashSet<>();

        cities.add("New York");
        cities.add("Paris");
        cities.add("Tokyo");
        cities.add("Paris"); // Duplicate

        System.out.println("Cities: " + cities);
        System.out.println("Contains Tokyo? " + cities.contains("Tokyo"));

        cities.remove("New York");
        System.out.println("After removal: " + cities);
    }
}