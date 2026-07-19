package ca.qc.vc.week3.lesson8;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("David");

        Iterator<String> iterator = students.iterator();

        while (iterator.hasNext()) {

            String student = iterator.next();

            System.out.println(student);

            if (student.equals("Bob")) {
                iterator.remove();
            }
        }

        System.out.println("After removal: " + students);
    }
}