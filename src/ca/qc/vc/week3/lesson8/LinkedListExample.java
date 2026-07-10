package ca.qc.vc.week3.lesson8;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Alice");
        queue.add("Bob");
        queue.add("Charlie");

        System.out.println("Queue: " + queue);

        queue.addFirst("Zara");
        System.out.println("After addFirst: " + queue);

        queue.removeLast();
        System.out.println("After removeLast: " + queue);
    }
}
