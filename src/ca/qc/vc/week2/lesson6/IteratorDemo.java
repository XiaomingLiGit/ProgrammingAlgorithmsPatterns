package ca.qc.vc.week2.lesson6;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 3.8));
        students.add(new Student("Bob", 3.5));
        students.add(new Student("Charlie", 3.9));

        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println(s);
        }
    }
}

