package ca.qc.vc.week3.lesson8;

import java.util.ArrayList;

public class ArrayListCRUDExample {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        // Create
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add(1, "David");
        System.out.println("After adding: " + students);

        // Read
        String student = students.get(2);
        System.out.println("Student at index 2: " + student);
        boolean exists = students.contains("Bob");
        System.out.println("Contains Bob: " + exists);
        int index = students.indexOf("Charlie");
        System.out.println("Index of Charlie: " + index);
        System.out.println("All students:");
        for (String name : students) {
            System.out.println(name);
        }

        // Update
        students.set(1, "Emily");
        System.out.println("After updating: " + students);

        // Delete by value
        students.remove("Bob");
        System.out.println("After removing Bob: " + students);
        // Delete by index
        students.remove(0);
        System.out.println("After removing index 0: " + students);
        // Delete all elements
        students.clear();
        System.out.println("After clearing: " + students);
        System.out.println("Is empty: " + students.isEmpty());
    }
}