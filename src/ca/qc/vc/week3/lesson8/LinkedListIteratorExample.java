package ca.qc.vc.week3.lesson8;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIteratorExample {

    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        Iterator<String> iterator = queue.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}